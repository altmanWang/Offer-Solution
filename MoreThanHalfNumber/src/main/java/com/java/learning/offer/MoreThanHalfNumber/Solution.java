package com.java.learning.offer.MoreThanHalfNumber;

import java.util.HashMap;
import java.util.Iterator;
/**
 * Created by altman on 18-2-16.
 */
import java.util.Iterator;
import java.util.HashMap;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        int result = 0;
        HashMap<Integer, Integer> int2count = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < array.length; i++){
            int count = int2count.getOrDefault(array[i], 0);
            int2count.put(array[i], count+1);
        }
        Iterator iter = int2count.keySet().iterator();
        while (iter.hasNext()){
            Object obj = iter.next();
            if((Integer)int2count.get(obj) > array.length/2)
                return (Integer)obj;
        }
        return result;
    }
}
