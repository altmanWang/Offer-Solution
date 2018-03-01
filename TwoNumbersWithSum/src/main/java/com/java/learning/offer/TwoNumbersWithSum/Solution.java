package com.java.learning.offer.TwoNumbersWithSum;

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if(array == null || array.length == 0 || array.length == 1)
            return results;
        FindNumbersWithSum(array, sum, 0, array.length-1, results);
        return results;
    }
    public void FindNumbersWithSum(int[] array, int sum, int start, int end, ArrayList<Integer> lists){
        if(start >= end)
            return;
        int tmp = array[start] + array[end];
        if(tmp == sum){
            lists.add(array[start]);
            lists.add(array[end]);
        }else if(tmp < sum){
            FindNumbersWithSum(array, sum, start+1, end, lists);
        }else{
            FindNumbersWithSum(array, sum, start, end-1, lists);
        }
    }
}
