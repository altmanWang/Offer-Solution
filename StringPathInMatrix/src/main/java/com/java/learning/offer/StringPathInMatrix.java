package com.java.learning.offer;

public class StringPathInMatrix {
    public boolean hashPath(char[][] matrix, String str){
        if(matrix == null || matrix.length ==0 || str == null)
            return false;
        char[] chars = str.toCharArray();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i <matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(hashPathCore(matrix, chars, i, j, 0, visited))
                    return true;
            }
        }
        return false;
    }
    public boolean hashPathCore(char[][] matrix, char[] chars, int row, int col, int index, boolean[][] visited){
        if(index == chars.length)
            return true;

        if(row>=0 && col>=0 && row< matrix.length && col<matrix[row].length && visited[row][col]==false && matrix[row][col] == chars[index]){
            System.out.println(matrix[row][col]);
            visited[row][col] = true;
            boolean result =  hashPathCore(matrix, chars, row+1,col,index+1,visited) || hashPathCore(matrix, chars, row-1,col,index+1,visited) ||
                               hashPathCore(matrix, chars, row,col-1,index+1,visited) || hashPathCore(matrix, chars, row,col+1,index+1,visited);
            if(result==false){
                visited[row][col] = false;
            }
            return result;
        }
        return false;
    }
}
