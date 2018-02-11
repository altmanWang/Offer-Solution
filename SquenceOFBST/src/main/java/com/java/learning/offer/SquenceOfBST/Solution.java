package com.java.learning.offer.SquenceOfBST;

/**
 * Created by altman on 18-2-11.
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;
        return VerifySquenceOfBST(sequence, 0,sequence.length-1);
    }
    public boolean VerifySquenceOfBST(int[] sequence, int start, int end){
        if((end-start) < 0)
            return false;
        int root = sequence[end];
        int leftEnd;
        for(leftEnd = start; leftEnd <= end-1; leftEnd++){
            if(sequence[leftEnd] > root){
                break;
            }
        }
        int rightEnd;
        for(rightEnd = leftEnd; rightEnd <= end-1; rightEnd++){
            if(sequence[rightEnd] < root)
                return false;
        }
        boolean left = true;
        boolean right = true;
        if(leftEnd > start)
            left = VerifySquenceOfBST(sequence, start, leftEnd-1);
        if(rightEnd < end-1)
            right = VerifySquenceOfBST(sequence, leftEnd, rightEnd);
        return (left && right);
    }
}