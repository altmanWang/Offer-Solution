package com.java.learning.offer;

public class Solution {
    public int NumberOf1(int n) {
        if(n == 0)
            return 0;
        int nums = 0;

        while(n!=0){
            nums +=1;
            n = n & (n-1);
        }
        return nums;
    }
}