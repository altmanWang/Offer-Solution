package com.java.learning.offer;

import org.junit.Assert;

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
        int[] nums = {2,3,5,4,3,2,6,7};
        int length = nums.length;
        Assert.assertEquals(3, solution.getDupication(nums,length));
    }

}