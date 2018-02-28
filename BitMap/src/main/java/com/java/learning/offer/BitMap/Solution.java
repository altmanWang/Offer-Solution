package com.java.learning.offer.BitMap;

public class Solution {
    public static void main(String[] args){
        int bitMap = 0;
        int[] nums = {4,3,1,2,0,5,7};
        for(int i = 0; i < nums.length; i++){
            int index = nums[i] % 10;
            int mask = 1 << index;
            bitMap |= mask;
        }
        for(int i = 0; i < 10; i++){
            if((bitMap & 1) == 1)
                System.out.println(i);
            bitMap = bitMap >> 1;
        }
    }
}
