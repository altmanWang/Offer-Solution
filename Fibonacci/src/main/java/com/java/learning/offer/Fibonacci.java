package com.java.learning.offer;

public class Fibonacci {
    public int approach(int n){
        if(n < 2){
            return n;
        }
        int one = 0;
        int two = 1;
        int tmp = 0;
        for(int i =2; i <= n; i++){
            tmp = one + two;
            one = two;
            two = tmp;
        }
        return tmp;
    }
}
