package com.java.learning.offer.Sortion;

public class BubbleSort {
    public static void sort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length -i -1; j++){
                if(nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
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
