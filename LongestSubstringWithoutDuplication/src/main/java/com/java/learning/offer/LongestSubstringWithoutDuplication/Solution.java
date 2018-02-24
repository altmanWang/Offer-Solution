package com.java.learning.offer.LongestSubstringWithoutDuplication;

public class Solution {
    public int longestSubstringWithoutDuplication(String str){
        if(str == null || str.length() == 0)
            return 0;
        int curLength = 0;
        int maxLength = -1;
        int[] position = new int[26];
        for(int i = 0; i < position.length; i++)
            position[i] = -1;
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(position[chars[i] - 'a'] < 0 || i - position[chars[i]-'a'] > curLength)
                curLength += 1;
            else {
                if(curLength > maxLength)
                    maxLength = curLength;
                curLength = i - position[chars[i]-'a'];
            }
            position[chars[i] - 'a'] = i;
            if(curLength > maxLength)
                maxLength = curLength;
        }
        return maxLength;
    }
}
