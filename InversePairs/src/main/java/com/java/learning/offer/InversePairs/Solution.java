package com.java.learning.offer.InversePairs;

public class Solution {
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        int[] copy = new int[array.length];
        int count = InversePairs(array, copy, 0, array.length - 1);
        return count;
    }
    public int InversePairs(int[] array, int[] copy, int start, int end){
        if(start == end){
            return 0;
        }
        int length = (end - start) / 2;
        int left = InversePairs(array, copy, start, start + length);
        int right = InversePairs(array, copy, start + length + 1, end);
        int count = merge(array, copy, start, start + length, end);
        return count + left + right;
    }
    public int merge(int[] array, int[] copy, int start, int mid, int end){
        for(int i =  start; i <= end; i++){
            copy[i] = array[i];
        }
        int i = mid;
        int j = end;
        int count = 0;
        for(int k = end; k >= start; k--){
            // 若右边用尽，则左侧直接复制
            if(j < mid+1) array[k] = copy[i--];
            // 若左边用尽，则右侧直接复制
            else if(i < start) array[k] = copy[j--];
            else if(copy[i] > copy[j]){
                array[k] = copy[i--];
                count += (j - mid);
            }else{
                array[k] = copy[j--];
            }
        }
        return count;
    }
}
