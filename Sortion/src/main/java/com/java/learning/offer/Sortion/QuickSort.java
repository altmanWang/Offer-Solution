package com.java.learning.offer.Sortion;

public class QuickSort {
    public static void sort(int[] nums){
        sort(nums, 0, nums.length-1);
    }
    public static void sort(int[] nums, int start, int end){
        if(start >= end)
            return;
        int j = partition(nums, start, end);
        sort(nums, start, j-1);
        sort(nums, j+1, end);
    }
    public static int partition(int[] nums, int start, int end){
        int i = start;
        int j = end+1;
        int v = nums[i];
        while (true){
            while (nums[++i] < v) if(i==end) break;
            while (nums[--j] > v) if(j==start) break;
            if(i>=j) break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int tmp = nums[start];
        nums[start] = nums[j];
        nums[j] = tmp;
        return j;
    }
    public static void main(String[] args){
        int[] nums = {8,-1,10,2,3,6,5,7,4,1,9,0};
        sort(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }
}
