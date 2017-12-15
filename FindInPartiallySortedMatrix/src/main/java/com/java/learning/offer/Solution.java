package com.java.learning.offer;

public class Solution {
    public boolean Find(int[][] matrix, int length, int target){
        if(matrix == null || length <= 0)
            return false;
        int i = 0;
        int j = length -1;
        while (i >= 0 && j >= 0 && i < length && j < length){
            int num = matrix[i][j];
            if(num < target){
                i +=1;
            }else if(num > target){
                j -= 1;
            }else
                return true;
        }
        return false;
    }
}
