package com.java.learning.offer;

public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        if(root.left != null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);
    }
}
