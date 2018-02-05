package com.java.learning.offer;

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nexNode = null;
        while(curNode != null){
            nexNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nexNode;
        }
        return preNode;
    }
}
