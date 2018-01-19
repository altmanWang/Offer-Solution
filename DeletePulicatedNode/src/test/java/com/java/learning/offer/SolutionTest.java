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
    public void test0(){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode result = solution.deleteDuplication(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    @Test
    public void test1(){
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode result = solution.deleteDuplication(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}