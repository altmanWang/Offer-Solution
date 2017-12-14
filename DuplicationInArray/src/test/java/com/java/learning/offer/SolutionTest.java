package com.java.learning.offer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;
    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void test(){
        int[] nums = {2,3,1,0,2,5,3};
        int length = nums.length;
        boolean result = solution.duplicate(nums, length);
        Assert.assertEquals(true, result);
    }
}