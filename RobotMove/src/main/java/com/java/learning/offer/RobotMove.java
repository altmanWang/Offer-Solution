package com.java.learning.offer;

public class RobotMove {
    public int movingCount(int threshold, int rows, int cols){
        if(threshold <0 || rows <=0 || cols <= 0)
            return -1;
        boolean[][] visited = new boolean[rows][cols];
        int count = movingCountCore(threshold,0,0,visited);
        return count;
    }
    public int movingCountCore(int t, int i, int j, boolean[][] visited){
        if( i>=0 && i<visited.length && j>=0 && j<visited[i].length && visited[i][j] == false && getDigitSum(i)+getDigitSum(j)<= t){
            //System.out.println(getDigitSum(i)+getDigitSum(j));
            visited[i][j] = true;
            int count = 1;
            count = count + movingCountCore(t, i+1, j, visited) + movingCountCore(t, i-1,j,visited) + movingCountCore(t, i, j+1, visited) + movingCountCore(t, i, j-1,visited);
            return count;
        }
        return 0;
    }
    public int getDigitSum(int num){
        int sum = 0;
        while (num > 0){
            sum += num%10;
            num = num / 10;
        }
        return sum;
    }
}
