package com.java.learning.offer;

public class Solution {
    public static TreeNode GetNext(TreeNode node){
        if(node == null)
            return null;

        TreeNode next = node;
        if(next.rightNode != null){
            next = next.rightNode;
            while (next.leftNode != null)
                next = next.leftNode;
        }else if(next.parentNode != null){
            TreeNode parent = next.parentNode;
            while (next.parentNode!=null && next != parent.leftNode){
                next = parent;
                parent = parent.parentNode;
            }
            next = parent;
        }
        return next;

    }
}
