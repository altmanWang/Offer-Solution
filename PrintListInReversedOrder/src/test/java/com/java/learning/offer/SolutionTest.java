package com.java.learning.offer;

import org.junit.After;
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
    public void test1(){
        ListNode head = new ListNode(0);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        head.next = second;
        second.next = third;
        String expected = "210";
        assertEquals(expected, solution.PrintListReversingly_Recursively(head));
    }

}