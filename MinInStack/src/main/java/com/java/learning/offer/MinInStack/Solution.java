package com.java.learning.offer.MinInStack;

import java.util.Stack;

public class Solution {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
        if(stack.size() == 1){
            minStack.push(node);
        }else{
            if(node < minStack.peek()){
                minStack.push(node);
            }else{
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}