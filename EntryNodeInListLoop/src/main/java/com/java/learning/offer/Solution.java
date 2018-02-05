package com.java.learning.offer;

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null)
            return null;
        ListNode tmp = IsLoop(pHead);
        if(tmp == null)
            return null;
        int length = lengthOfLoop(tmp);

        ListNode fastIndex = pHead;
        ListNode slowIndex = pHead;
        for(int i = 0; i < length; i++)
            fastIndex = fastIndex.next;
        while(fastIndex != slowIndex){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }
        return fastIndex;
    }
    public int lengthOfLoop(ListNode node){
        ListNode index = node;
        int length = 1;
        while(index.next != node){
            index = index.next;
            length +=1;
        }
        return length;

    }
    public ListNode IsLoop(ListNode pHead){
        ListNode fastIndex = pHead;
        ListNode slowIndex = pHead;
        while(fastIndex.next != null && fastIndex.next.next != null){
            fastIndex = fastIndex.next.next;
            slowIndex = slowIndex.next;
            if(slowIndex == fastIndex)
                return slowIndex;
        }
        return null;
    }
}
