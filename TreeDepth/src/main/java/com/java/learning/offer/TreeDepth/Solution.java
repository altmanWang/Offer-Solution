package com.java.learning.offer.TreeDepth;

public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        int high = 1;
        int leftHigh = TreeDepth(root.left);
        int rightHigh = TreeDepth(root.right);
        high = leftHigh >= rightHigh? leftHigh + 1:rightHigh + 1;
        return high;

    }
}
