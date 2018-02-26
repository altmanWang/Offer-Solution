package com.java.learning.offer.InversePairs;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;
    @org.junit.Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        solution = null;
    }
    @org.junit.Test
    public void test(){
        int[] nums = {0,7,5,6,4,1};
        assertEquals(9, solution.InversePairs(nums));
    }

}