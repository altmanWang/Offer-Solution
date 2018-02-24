package com.java.learning.offer.MaxValueOfGifts;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution;
    @org.junit.Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        solution = null;
    }
    @org.junit.Test
    public void test1(){
        int[][] values = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        assertEquals(53,solution.getMaxValues(values));
    }

}