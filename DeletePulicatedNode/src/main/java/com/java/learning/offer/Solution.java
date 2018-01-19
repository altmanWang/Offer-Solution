package com.java.learning.offer;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode preNode = null;
        ListNode curNode = pHead;
        while(curNode!=null && curNode.next!=null){
            if(curNode.val != curNode.next.val){
                preNode = curNode;
                curNode = curNode.next;
            }else{
                int val = curNode.val;
                curNode = curNode.next;
                while(curNode!=null && curNode.val == val){
                    curNode = curNode.next;
                }

                if(preNode == null){
                    pHead = curNode;
                }else{
                    preNode.next = curNode;
                }

            }
        }
        return pHead;
    }
}
