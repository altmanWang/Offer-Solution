package com.java.learning.offer.Sortion;

public class MergeSort {
    public static void sort(int[] nums){
        int[] backup = new int[nums.length];
        sort(nums, backup, 0, nums.length-1);
    }
    public static void sort(int[] nums, int[] backup, int start, int end){
        if(start >= end)
            return;
        int length = (end - start)/2;
        sort(nums, backup, start, start+length);
        sort(nums, backup, start+length+1, end);
        merge(nums, backup, start, start+length, end);
    }
    public static void merge(int[] nums, int[] backup, int start, int mid, int end){
        for(int i = start; i <= end; i++)
            backup[i] = nums[i];
        int i = mid;
        int j = end;
        for(int k = end; k>=start; k--){
            if(i < start){
                nums[k] = backup[j--];
            }else if(j < mid+1){
                nums[k] = backup[i--];
            }else if(backup[i] > backup[j]){
                nums[k] = backup[i--];
            }else {
                nums[k] = backup[j--];
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
