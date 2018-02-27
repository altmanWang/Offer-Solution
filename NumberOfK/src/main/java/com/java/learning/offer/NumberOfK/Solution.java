package com.java.learning.offer.NumberOfK;

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0)
            return 0;
        int firstPosition, lastPosition = 0;
        firstPosition = GetFirstPosition(array, k, 0, array.length-1);
        lastPosition = GetLastPosition(array, k, 0, array.length-1);
        if(firstPosition != -1 && lastPosition != -1)
            return lastPosition - firstPosition +1;
        return 0;
    }
    public int GetFirstPosition(int[] array, int k, int start, int end){
        if(start>end)
            return -1;
        int middle = start + (end - start)/2;
        if(array[middle] > k){
            return GetFirstPosition(array, k, start, middle-1);
        }else if(array[middle] < k) {
            return GetFirstPosition(array, k, middle+1, end);
        }
        if(middle > 0 && array[middle-1] != k || middle == 0)
            return middle;
        return GetFirstPosition(array, k, start, middle-1);
    }
    public int GetLastPosition(int[] array, int k, int start, int end){
        if(start>end)
            return -1;
        int middle = start + (end - start)/2;
        if(array[middle] > k){
            return GetLastPosition(array, k, start, middle-1);
        }else if(array[middle] < k) {
            return GetLastPosition(array, k, middle+1, end);
        }
        if(middle < array.length-1 && array[middle+1] != k || middle == array.length-1)
            return middle;
        return GetLastPosition(array, k, middle+1, end);
    }
}
