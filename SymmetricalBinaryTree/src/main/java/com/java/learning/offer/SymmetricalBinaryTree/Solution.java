package com.java.learning.offer.SymmetricalBinaryTree;

public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null)
            return true;
        return isSymmetricalCore(pRoot.left, pRoot.right);
    }
    boolean isSymmetricalCore(TreeNode pRoot1, TreeNode pRoot2){
        if(pRoot1 == null && pRoot2 == null)
            return true;
        if(pRoot1 == null || pRoot2 == null)
            return false;
        if(pRoot1.val != pRoot2.val)
            return false;
        return isSymmetricalCore(pRoot1.left, pRoot2.right) && isSymmetricalCore(pRoot1.right, pRoot2.left);
    }
}
