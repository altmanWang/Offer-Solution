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
    public void find(){
        int[][] matrix = {{1,2,8,9},
                           {2,4,9,12},
                           {4,7,10,13},
                           {6,8,11,15}};
        int length = matrix[0].length;
        int target = 7;
        Assert.assertEquals(true, solution.Find(matrix, length, target));
    }
    @Test
    public void unfind0(){
        int[][] matrix = {{1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        int length = matrix[0].length;
        int target = 16;
        Assert.assertEquals(false, solution.Find(matrix, length, target));
    }
    @Test
    public void unfind1(){
        int[][] matrix = {{1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        int length = matrix[0].length;
        int target = 0;
        Assert.assertEquals(false, solution.Find(matrix, length, target));
    }
    @Test
    public void unfind2(){
        int[][] matrix = {{1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        int length = matrix[0].length;
        int target = 3;
        Assert.assertEquals(false, solution.Find(matrix, length, target));
    }
    @Test
    public void nothing(){
        int[][] matrix = null;
        int length = 0;
        int target = 3;
        Assert.assertEquals(false, solution.Find(matrix, length, target));
    }

}