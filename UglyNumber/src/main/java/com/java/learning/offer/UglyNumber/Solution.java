package com.java.learning.offer.UglyNumber;

public class Solution {
    public int Min(int num1, int num2, int num3){
        int min = num1 > num2 ? num2 : num1;
        return min > num3 ? num3 : min;
    }
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0)
            return 0;
        int[] nums = new int[index];
        nums[0] = 1;
        int numsIndex = 1;

        int num2 = 0;
        int num3 = 0;
        int num5 = 0;
        while(numsIndex < index){
            int min = Min(nums[num2]*2, nums[num3]*3, nums[num5]*5);
            nums[numsIndex] = min;
            while(nums[num2]*2 <= nums[numsIndex])
                num2++;
            while(nums[num3]*3 <= nums[numsIndex])
                num3++;
            while(nums[num5]*5 <= nums[numsIndex])
                num5++;
            numsIndex++;
        }
        return nums[index - 1];
    }

}