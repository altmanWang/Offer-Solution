package com.java.learning.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Main {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return lists;
        Arrays.sort(nums);
        dfs(lists, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return lists;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if(temp.size() == nums.length) {
            System.out.println(temp);
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i] || i > 0 && used[i-1]==false && nums[i] == nums[i-1]) continue;
            used[i] = true;
            temp.add(nums[i]);
            dfs(res, temp, nums, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
    public static void main(String[] args){
        int[] nums = {1,2,2};
        new Main().permuteUnique(nums);
    }
}