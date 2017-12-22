package com.java.learning.offer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
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

    public void printTree(BinaryTreeNode root){
        LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode leaf = queue.removeFirst();
            System.out.print(leaf.value);
            if(leaf.leftNode!=null){
                queue.add(leaf.leftNode);
            }
            if(leaf.rightNode!=null){
                queue.add(leaf.rightNode);
            }
        }
    }

    @Test
    public void test(){
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};

        BinaryTreeNode root = solution.Construct(preorder, inorder);
        printTree(root);
    }

}