package com.java.learning.offer;

import java.util.Arrays;
import java.util.Collections;
class Hindex {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        if (citations[citations.length - 1] == 0) return 0;
        int count = 0;
        for(int i = citations.length - 1; i >=0 ; i--){
            if(citations[i] > count){
                count ++;
            }else{
                return count;
            }
        }
        return count;

    }
    public static void main(String[] args){
        int[] nums = {0,1,2,2,2,4,6};
        System.out.println(new Hindex().hIndex(nums));
    }
}
