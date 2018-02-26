package com.java.learning.offer.FirstCommonNodesInLists;

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead1 == null)
            return null;
        int length1 = 0;
        int length2 = 0;

        ListNode index1 = pHead1;
        ListNode index2 = pHead2;

        while(index1 != null){
            length1++;
            index1 = index1.next;
        }

        while(index2 != null){
            length2++;
            index2 = index2.next;
        }
        ListNode result;
        if(length1 > length2){
            result = FindFirstCommonNode(pHead1, pHead2, length1-length2);
        }else{
            result = FindFirstCommonNode(pHead2, pHead1, length2-length1);
        }
        return result;
    }
    public ListNode FindFirstCommonNode(ListNode index1, ListNode index2, int length){
        for(int i = 0; i < length; i++)
            index1 = index1.next;
        while(index1 !=null && index2 != null){
            if(index1 == index2)
                return index1;
            index1 = index1.next;
            index2 = index2.next;
        }
        return null;
    }
}
