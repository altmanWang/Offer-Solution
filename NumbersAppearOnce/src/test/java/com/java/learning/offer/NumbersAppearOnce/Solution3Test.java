package com.java.learning.offer.NumbersAppearOnce;

import static org.junit.Assert.*;

public class Solution3Test {
    Solution3 solution;
    @org.junit.Before
    public void setUp() throws Exception {
        solution = new Solution3();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        solution = null;
    }
    @org.junit.Test
    public void test(){
        int[] array = {1,1,1,5,2,2,2,4,4,4,3,3,3};
        assertEquals(5, solution.FindNumsAppearOnce(array));
    }

}