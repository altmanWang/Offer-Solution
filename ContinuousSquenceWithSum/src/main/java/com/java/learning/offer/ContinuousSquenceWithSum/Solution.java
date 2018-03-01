package com.java.learning.offer.ContinuousSquenceWithSum;

import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(sum<=1)
            return results;
        for(int i = 1; i < sum; i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(i);
            if(FindContinuousSequence(sum, list, i, i+1)){
                results.add(list);
            }
        }
        return results;
    }
    public boolean FindContinuousSequence(int sum, ArrayList<Integer> list, int small, int big){
        if(big >= sum)
            return false;
        int num = small+big;
        if(num == sum){
            list.add(big);
            return true;
        }else if(num < sum){
            list.add(big);
            return FindContinuousSequence(sum, list, num, big+1);
        }else{
            return false;
        }
    }
}
