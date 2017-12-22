package com.java.learning.offer;

import java.util.Stack;

public class Solution {
    public String PrintListReversingly_Recursively(ListNode head){
        if(head==null){
            return null;
        }
        ListNode index = head;
        String str = "";
        Stack stack = new Stack();
        while (index!=null){
            stack.push(index.value);
            index = index.next;
        }
        while (!stack.isEmpty()){
            str += stack.pop() + "";
        }
        return str;
    }
}
