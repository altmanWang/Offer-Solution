package com.java.learning.offer.ReverseWordsInSentence;

public class Solution {
    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0)
            return str;
        char[] chars = str.toCharArray();
        ReverseSentence(chars, 0, chars.length-1);
        int startIndex = 0;
        int endIndex = 0;

        while(startIndex<=chars.length-1 || endIndex < chars.length){
            if(endIndex == chars.length || chars[endIndex] == ' '){
                ReverseSentence(chars, startIndex, endIndex-1);
                endIndex++;
                startIndex = endIndex;
            }else{
                endIndex++;
            }
        }
        return new String(chars);
    }
    public void ReverseSentence(char[] chars, int start, int end){
        while(start <= end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
}