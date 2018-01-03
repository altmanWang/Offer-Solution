package com.java.learning.offer;
import java.util.Stack;

public class CQueue<T> {
    public Stack<T> stack1 = new Stack<T>();
    public Stack<T> stack2 = new Stack<T>();
    public void appendTail(T input){
        stack1.push(input);
    }
    public T deleteHead(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
