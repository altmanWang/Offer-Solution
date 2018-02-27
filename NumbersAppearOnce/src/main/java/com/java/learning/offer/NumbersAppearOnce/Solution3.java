package com.java.learning.offer.NumbersAppearOnce;

public class Solution3 {
    public int FindNumsAppearOnce(int [] array) {
        if(array == null || array.length == 0)
            return -1;
        int[] bits = new int[32];
        for(int i = 0 ; i < array.length; i++){
            int mask = 1;
            for(int j = 31; j > 0; j--){
                if((array[i] & mask)!=0){
                    bits[j] +=1;
                }
                mask = mask << 1;
            }
        }
        int result = 0;
        for(int i = 0; i < bits.length; i++){
            result = result << 1;
            result += (bits[i] % 3);
        }
        return result;
    }
}
