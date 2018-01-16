package com.java.learning.offer;

public class CuttingRope {
    public int maxProductAfterCutting(int length){
        if(length<2)
            return 0;
        if(length==2)
            return 1;
        if(length==3)
            return 2;
        int[] prodcuts = new int[length+1];
        prodcuts[0] = 0;
        prodcuts[1] = 1;
        prodcuts[2] = 2;
        prodcuts[3] = 3;
        for(int i = 4; i <= length; i++){
            int max = -1;
            for(int j = 1; j <= i/2; j++){
                int score = prodcuts[j]*prodcuts[i-j];
                if(score > max)
                    max = score;
            }
            prodcuts[i] = max;
        }
        return prodcuts[length];
    }
}
