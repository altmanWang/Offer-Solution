package com.java.learning.offer.StackPushPopOrder;

import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || pushA.length == 0 || popA == null || popA.length == 0)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        int indexPop = 0;
        int indexPush = 0;
        while(indexPop < popA.length){
            while(stack.empty() || stack.peek() != popA[indexPop]){
                if(indexPush >= pushA.length)
                    break;
                stack.push(pushA[indexPush]);
                indexPush += 1;
            }
            if(stack.peek()!=popA[indexPop])
                return false;
            stack.pop();
            indexPop += 1;
        }
        return true;
    }
}
