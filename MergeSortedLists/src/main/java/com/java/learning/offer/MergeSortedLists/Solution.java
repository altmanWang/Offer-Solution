package com.java.learning.offer.MergeSortedLists;

public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;


        ListNode index = null;

        if(list1.val <= list2.val){
            index = new ListNode(list1.val);
            list1 = list1.next;
        }else{
            index = new ListNode(list2.val);
            list2 = list2.next;
        }
        ListNode head = index;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                index.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                index.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            index = index.next;
        }
        if(list1 != null){
            index.next = list1;
        }else if(list2 != null){
            index.next = list2;
        }

        return head;
    }
}