package com.java.learning.offer.MaxInSlidingWindow;import java.util.ArrayList;
import java.util.LinkedList;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> lists = new ArrayList<Integer>();
        if(num == null || num.length ==0 || size <=0 || size > num.length)
            return lists;
        LinkedList<Integer> dequeue = new LinkedList<Integer>();
        for(int i = 0 ; i < size; i++){
            if(!dequeue.isEmpty() && num[i] > num[dequeue.getLast()])
                dequeue.removeLast();
            dequeue.addLast(i);
        }

        for(int i = size; i < num.length; i++){
            lists.add(num[dequeue.getFirst()]);
            while(!dequeue.isEmpty() && num[i] >= num[dequeue.getLast()])
                dequeue.removeLast();
            if(!dequeue.isEmpty() && i - dequeue.getFirst() >= size)
                dequeue.removeFirst();
            dequeue.addLast(i);
        }
        lists.add(num[dequeue.getFirst()]);
        return lists;
    }
}
