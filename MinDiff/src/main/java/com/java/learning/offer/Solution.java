package com.java.learning.offer;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int getMinDiff(int[] nums){
        if(nums == null || nums.length == 0)
            return -1;
        int total_sum = 0;
        for(int i = 0 ; i < nums.length; i++)
            total_sum += nums[i];

        int n = nums.length;
        int m = total_sum / 2;
        int[][] matrix = new int[n+1][m+1];
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= m; j++){
                if(nums[i-1] > j){
                    matrix[i][j] = matrix[i-1][j];
                }else{
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j-nums[i-1]]+nums[i-1]);
                }
            }
        }
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        int j = m;
        for(int i = n; i > 0; i--){
            if(matrix[i][j] > matrix[i-1][j]){
                list1.add(nums[i-1]);
                j = j - nums[i-1];
            }else{
                list2.add(nums[i-1]);
            }
        }
        System.out.println(list1);
        System.out.println(list2);

        return matrix[n][m];
    }
    public static void main(String[] args){
        int[] nums = {10,11,9,8,12,13,9,9};
        System.out.println(new Solution().getMinDiff(nums));
    }
}
