package com.java.learning.offer.MergeSortedLists;

public class RecursiveSolution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode mergeNode = null;
        if(list1.val <= list2.val){
            mergeNode = list1;
            mergeNode.next = Merge(list1.next, list2);
        }else{
            mergeNode = list2;
            mergeNode.next = Merge(list1,list2.next);
        }
        return mergeNode;
    }
}
