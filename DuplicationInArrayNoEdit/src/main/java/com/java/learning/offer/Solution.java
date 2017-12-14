package com.java.learning.offer;

public class Solution {
    public int getDupication(int[] nums, int length){
        if(nums == null || length < 0){
            return -1;
        }
        int left = 1;
        int right = length - 1;
        while (right >= left){
            int middle = (right - left)/2 + left;
            int count = countRange(nums, length, left, middle);
            if(left == right){
                if(count > 1){
                    return left;
                }else {
                    break;
                }
            }
            // （middle-left）+1 ： 区间
            if(count > (middle - left ) + 1){
                right = middle;
            }else {
                left = middle + 1;
            }
        }
        return -1;
    }
    public int countRange(int[] nums, int length, int left, int right){
        int count = 0;
        for(int i = 0; i < length; i++){
            if(nums[i] >= left && nums[i] <= right)
                count += 1;
        }
        return count;
    }
}
