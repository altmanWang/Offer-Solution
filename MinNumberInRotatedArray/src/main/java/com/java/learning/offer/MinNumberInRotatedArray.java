package com.java.learning.offer;

public class MinNumberInRotatedArray {
    public int Min(int[] nums){
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length-1;
        int middle = left;
        while (nums[left]>=nums[right]){
            middle = left + (right - left) / 2;
            if(right - left == 1){
                middle = right;
                break;
            }
            if(nums[left] == nums[right] && nums[middle] == nums[left]){
                middle = left;
                for(int i = left + 1; i < right; i++){
                    if(nums[middle] > nums[i]){
                        middle = i;
                        break;
                    }
                }
                return nums[middle];
            }
            if(nums[middle] >= nums[left]){
                left = middle;
            }else if(nums[middle] <= nums[right]){
                right = middle;
            }
        }
        return nums[middle];
    }
}
