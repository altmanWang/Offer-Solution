package com.java.learning.offer.LeftRotateString;

public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || n == 0)
            return str;
        char[] chars = str.toCharArray();
        if(n<=chars.length){
            //翻转前n个字符
            ReverseSentence(chars, 0, n-1);
            //翻转剩余的字符
            ReverseSentence(chars, n, chars.length-1);
            //翻转整个字符串
            ReverseSentence(chars, 0, chars.length-1);
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
