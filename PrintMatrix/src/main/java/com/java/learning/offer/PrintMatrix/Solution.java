package com.java.learning.offer.PrintMatrix;

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null)
            return null;
        ArrayList<Integer> printer = new ArrayList<Integer>();
        int start = 0;
        while(matrix.length > start * 2 && matrix[0].length > start * 2){
            printMatrixCore(matrix,start,printer);
            start +=1;
        }
        return printer;
    }
    public void printMatrixCore(int[][] matrix, int start, ArrayList<Integer> printer){
        int endy = matrix.length - start -1;
        int endx = matrix[0].length - start -1;
        for(int i = start; i <= endx; i++){
            printer.add(matrix[start][i]);
        }
        if(start < endy){
            for(int i = start +1; i <= endy; i++){
                printer.add(matrix[i][endx]);
            }
        }

        if(start < endx && start < endy){
            for(int i = endx -1 ; i >= start; i--){
                printer.add(matrix[endy][i]);
            }
        }
        if(start < endx && start < endy-1){
            for(int i = endy -1 ; i >= start +1 ; i--){
                printer.add(matrix[i][start]);
            }
        }

    }
}