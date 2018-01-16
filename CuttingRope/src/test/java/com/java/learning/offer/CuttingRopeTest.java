package com.java.learning.offer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CuttingRopeTest {
    private CuttingRope solution;
    @org.junit.Before
    public void setUp() throws Exception {
        solution = new CuttingRope();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        solution = null;
    }
    @Test
    public void test(){
        Assert.assertEquals(18,solution.maxProductAfterCutting(8));

    }

}