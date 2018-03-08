package com.java.learning.offer.Sortion;

public class SelectSort {
    public static void sort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int minIndex = i;
            for(int j = i; j < nums.length; j++){
                if(nums[minIndex] > nums[j]){
                    minIndex = j;
                }
            }
            int tmp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = tmp;
        }
    }
    public static void main(String[] args){
        int[] nums = {8,-1,10,2,3,6,5,7,4,1,9,0};
        sort(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }
}
