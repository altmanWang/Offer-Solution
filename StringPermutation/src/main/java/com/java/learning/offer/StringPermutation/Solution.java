package com.java.learning.offer.StringPermutation;

/**
 * Created by altman on 18-2-15.
 */
import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> lists = new ArrayList<String>();
        if(str == null)
            return lists;
        char[] chars = str.toCharArray();
        Permutation(chars, lists, 0);
        Collections.sort(lists);
        return lists;
    }
    public void Permutation(char[] chars, ArrayList<String> lists, int start){
        if(start == chars.length - 1){
            String str = String.valueOf(chars);
            if (lists.indexOf(str) < 0) {
                lists.add(str);
            }
        }
        for(int i = start; i < chars.length; i++){
            char tmp = chars[i];
            chars[i] = chars[start];
            chars[start] = tmp;

            Permutation(chars, lists, start+1);

            tmp = chars[i];
            chars[i] = chars[start];
            chars[start] = tmp;
        }
        return;
    }
}
