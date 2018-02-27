package com.java.learning.offer.NumbersAppearOnce;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array, int num1[] , int num2[]) {
        if(array == null || array.length == 0)
            return;
        int resultOR = 0;
        for(int i = 0; i < array.length; i++)
            resultOR ^= array[i];

        int indexBit = 0;
        while((resultOR & 1) == 0 && indexBit < 32){
            resultOR = resultOR >> 1;
            indexBit += 1;
        }

        num1[0] = 0;
        num2[0] = 0;
        for(int i = 0; i < array.length; i++){
            if(IsBit1(array[i], indexBit)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }
    public boolean IsBit1(int num, int index){
        num = num>>index;
        return (num & 1) == 1;
    }
}