package com.java.learning.offer.MaxValueOfGifts;

public class Solution {
    public int getMaxValues(int[][] values){
        if(values == null || values.length == 0 || values[0] == null || values[0].length == 0){
            return 0;
        }
        int[][] maxValues = new int[values.length][values[0].length];
        for(int i = 0; i < values.length; i++){
            for(int j = 0; j < values[0].length; j++){
                maxValues[i][j] = values[i][j];
            }
        }

        for(int i = 0; i < maxValues.length; i++){
            for(int j = 0; j < maxValues[0].length; j++){
                int up = 0;
                int left = 0;
                if(i > 0)
                    up = maxValues[i-1][j];

                if(j > 0)
                    left = maxValues[i][j-1];
                maxValues[i][j] = up > left ? up + maxValues[i][j] : left + maxValues[i][j];
            }
        }

        return maxValues[maxValues.length - 1][maxValues[0].length - 1];
    }
}
