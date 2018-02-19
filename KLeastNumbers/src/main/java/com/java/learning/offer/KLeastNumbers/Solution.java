package com.java.learning.offer.KLeastNumbers;
import java.util.PriorityQueue;
import java.util.ArrayList;
/**
 * Created by altman on 18-2-19.
 */

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> lists = new ArrayList<Integer>();
        if(input == null || input.length == 0 || k == 0 || k > input.length)
            return lists;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2)->{
            if(o1 > o2)
                return -1;
            if(o1 < o2)
                return 1;
            return 0;
        });
        for(int i = 0; i < input.length; i++){
            if(queue.size()<k){
                queue.add(input[i]);
            }else{
                if(queue.peek() > input[i]){
                    queue.poll();
                    queue.add(input[i]);
                }
            }
        }
        while(!queue.isEmpty()){
            lists.add(queue.poll());
        }
        return lists;
    }
}