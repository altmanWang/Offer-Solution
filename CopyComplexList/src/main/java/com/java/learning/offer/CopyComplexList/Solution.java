package com.java.learning.offer.CopyComplexList;

/**
 * Created by altman on 18-2-13.
 */
import java.util.HashMap;
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        RandomListNode srcIndex = pHead;
        HashMap<RandomListNode, RandomListNode> container = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode tarIndex = new RandomListNode(srcIndex.label);
        container.put(srcIndex, tarIndex);
        while(srcIndex.next !=null){
            srcIndex = srcIndex.next;
            tarIndex.next = new RandomListNode(srcIndex.label);
            tarIndex = tarIndex.next;
            container.put(srcIndex, tarIndex);
        }
        srcIndex = pHead;
        while(srcIndex!=null){
            tarIndex = container.get(srcIndex);
            if(srcIndex.random != null)
                tarIndex.random = container.get(srcIndex.random);
            srcIndex = srcIndex.next;
        }
        return container.get(pHead);
    }
}