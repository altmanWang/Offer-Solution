package com.java.learning.offer.LongestSubstringWithoutDuplication;

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
        String str = "arabcacfr";
        assertEquals(4, solution.longestSubstringWithoutDuplication(str));
    }

}