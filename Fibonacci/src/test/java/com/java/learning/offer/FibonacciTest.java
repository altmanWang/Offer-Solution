package com.java.learning.offer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {
    private Fibonacci solution;
    @Before
    public void setUp() throws Exception {
        this.solution = new Fibonacci();
    }

    @After
    public void tearDown() throws Exception {
        this.solution = null;
    }
    @Test
    public void test(){
        Assert.assertEquals(1, this.solution.approach(2));
    }
    @Test
    public void test1(){
        Assert.assertEquals(3, this.solution.approach(4));
    }

}