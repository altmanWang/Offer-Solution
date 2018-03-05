package com.java.learning.offer.BalanceBinaryTree;

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;
        int deepth = IsBalanced_SolutionCore(root);
        return deepth!=-1;

    }
    public int IsBalanced_SolutionCore(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = IsBalanced_SolutionCore(root.left);
        int right = IsBalanced_SolutionCore(root.right);
        if(left!=-1 && right!=-1){
            int diff = Math.abs(left-right);
            if(diff <=1){
                return 1 + (left> right ? left : right);
            }
        }
        return -1;
    }
}
