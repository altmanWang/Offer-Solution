package com.java.learning.offer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinNumberInRotatedArrayTest {
    private MinNumberInRotatedArray solution;
    @org.junit.Before
    public void setUp() throws Exception {
        solution = new MinNumberInRotatedArray();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        solution = null;
    }
    @Test
    public void test0(){
        Assert.assertEquals(-1,solution.Min(null));
    }
    @Test
    public void test1(){
        int[] nums = {3,4,5,1,2};
        Assert.assertEquals(1,solution.Min(nums));
    }
    @Test
    public void test2(){
        int[] nums = {1,2,3,4,5};
        Assert.assertEquals(1,solution.Min(nums));
    }
    @Test
    public void test3(){
        int[] nums = {1,1,1,1,0,1};
        Assert.assertEquals(0,solution.Min(nums));
    }

}