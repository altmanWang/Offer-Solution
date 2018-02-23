package com.java.learning.offer.SortArrayForMinNumber;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0)
            return "";
        ArrayList<String> lists = new ArrayList<String>();
        PrintMinNumber(numbers, 0, lists);
        Collections.sort(lists);
        return lists.get(0);

    }
    public void PrintMinNumber(int[] numbers, int start, ArrayList<String> lists){
        if(start == numbers.length-1){
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < numbers.length; i++){
                str.append(numbers[i]);
            }
            lists.add(str.toString());
            return;
        }
        for(int i = start ; i < numbers.length; i++){
            int tmp = numbers[start];
            numbers[start] = numbers[i];
            numbers[i] = tmp;

            PrintMinNumber(numbers, start+1, lists);

            tmp = numbers[start];
            numbers[start] = numbers[i];
            numbers[i] = tmp;
        }
    }
}
