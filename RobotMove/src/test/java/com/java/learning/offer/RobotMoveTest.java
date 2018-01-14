package com.java.learning.offer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotMoveTest {
    private RobotMove solution;
    @Before
    public void setUp() throws Exception {
        solution = new RobotMove();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }
    @Test
    public void test(){
        Assert.assertEquals(45,solution.movingCount(8,10,10));
    }

}