package com.java.learning.offer.Sortion;

public class InsertSort {
    public static void sort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            for(int j = i; j > 0 && nums[j] < nums[j-1]; j--){
                int tmp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = tmp;
            }
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
