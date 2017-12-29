package com.java.learning.offer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;
    @org.junit.Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        solution = null;
    }
    @Test
    public void test(){
        TreeNode roota = new TreeNode(1);
        TreeNode nodeb = new TreeNode(2);
        TreeNode nodec = new TreeNode(3);
        TreeNode noded = new TreeNode(4);
        TreeNode nodee = new TreeNode(5);
        TreeNode nodef = new TreeNode(6);
        TreeNode nodeg = new TreeNode(7);
        TreeNode nodeh = new TreeNode(8);
        TreeNode nodei = new TreeNode(9);

        roota.leftNode = nodeb;
        roota.rightNode = nodec;

        nodeb.parentNode = roota;
        nodeb.leftNode = noded;
        nodeb.rightNode = nodee;

        noded.parentNode = nodeb;

        nodee.parentNode = nodeb;
        nodee.leftNode = nodeh;
        nodee.rightNode = nodei;

        nodeh.parentNode = nodee;
        nodei.parentNode = nodee;


        nodec.parentNode = roota;
        nodec.leftNode = nodef;
        nodec.rightNode = nodeg;

        nodef.parentNode = nodec;
        nodeg.parentNode = nodec;

        Assert.assertEquals(nodee, solution.GetNext(nodeh));

    }

}