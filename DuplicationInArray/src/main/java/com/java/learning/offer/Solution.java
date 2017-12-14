package com.java.learning.offer;

public class Solution {

    public boolean duplicate(int[] nums, int length){
        if(nums==null || nums.length == 0)
            return false;
        for(int i = 0; i < length; i++){
            if(nums[i] > length -1 || nums[i] < 0){
                return false;
            }
        }
        for(int i = 0; i < length; i++){
            while (nums[i]!=i){
                if(nums[i] == nums[nums[i]]){
                    return true;
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return false;
    }
}
