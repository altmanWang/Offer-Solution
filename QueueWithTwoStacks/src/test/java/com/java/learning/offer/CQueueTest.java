package com.java.learning.offer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CQueueTest {
    private CQueue<Integer> queue;
    @Before
    public void setUp() throws Exception {
        this.queue = new CQueue<Integer>();
    }

    @After
    public void tearDown() throws Exception {
        this.queue = null;
    }
    @Test
    public void test1(){
        this.queue.appendTail(1);
        this.queue.appendTail(2);
        this.queue.appendTail(3);
        Assert.assertEquals(new Integer(1), this.queue.deleteHead());
    }
    @Test
    public void test2(){
        this.queue.appendTail(1);
        this.queue.appendTail(2);
        this.queue.appendTail(3);

        this.queue.deleteHead();

        this.queue.appendTail(4);
        this.queue.appendTail(5);
        this.queue.appendTail(6);

        Assert.assertEquals(new Integer(2), this.queue.deleteHead());
    }

    @Test
    public void test3(){
        this.queue.appendTail(1);
        this.queue.appendTail(2);
        this.queue.appendTail(3);

        this.queue.deleteHead();
        this.queue.deleteHead();
        this.queue.deleteHead();

        this.queue.appendTail(4);
        this.queue.appendTail(5);
        this.queue.appendTail(6);

        Assert.assertEquals(new Integer(4), this.queue.deleteHead());
    }

}