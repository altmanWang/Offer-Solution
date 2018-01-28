package com.java.learning.offer;

public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null)
            return false;
        return matchCore(str, pattern, 0, 0);
    }
    public boolean matchCore(char[] str, char[] pattern, int i , int j){
        if(i == str.length && j == pattern.length)
            return true;
        if(i < str.length && j == pattern.length)
            return false;


        if(j+1 < pattern.length && pattern[j+1] == '*'){
            //若当前匹配上，则继续递归匹配
            if((i < str.length && str[i]==pattern[j]) || (pattern[j]=='.' && i < str.length)){
                return  //此次匹配成功，同时继续匹配str和pattern
                        matchCore(str, pattern, i+1, j+2)
                                //继续匹配str
                                || matchCore(str, pattern, i+1, j)
                                //忽略这次匹配
                                || matchCore(str, pattern, i, j+2);
            }else{
                //忽略这次匹配
                return matchCore(str, pattern, i, j+2);
            }
        }
        //如果相等或者遇见'.'则递归继续向下
        if((i < str.length && str[i]==pattern[j]) || (pattern[j]=='.' && i < str.length))
            return matchCore(str, pattern, i+1, j+1);
        return false;
    }
}
