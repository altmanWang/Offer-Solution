package com.java.learning.offer.FirstNotRepeatingChar;

import java.util.HashMap;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            map.put(chars[i], map.getOrDefault(chars[i],0) + 1);
        }
        for(int i = 0; i < chars.length; i++){
            if(map.get(chars[i]) == 1)
                return i;
        }
        return -1;
    }
}
