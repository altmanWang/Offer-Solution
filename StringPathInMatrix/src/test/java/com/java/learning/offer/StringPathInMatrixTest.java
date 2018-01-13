package com.java.learning.offer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringPathInMatrixTest {
    StringPathInMatrix solution;
    @Before
    public void setUp() throws Exception {
        solution = new StringPathInMatrix();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }
    @Test
    public void test(){
        char[][] matrix = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        String str = "bfce";
        Assert.assertEquals(true, solution.hashPath(matrix, str));
    }

}