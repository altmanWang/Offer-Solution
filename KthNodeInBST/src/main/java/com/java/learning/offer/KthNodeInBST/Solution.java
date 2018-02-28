package com.java.learning.offer.KthNodeInBST;

public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k == 0)
            return null;
        int[] num = {k};
        return KthNodeCoreCore(pRoot, num);

    }
    public TreeNode KthNodeCoreCore(TreeNode node, int[] k){
        if(node == null)
            return null;
        TreeNode target = null;
        target = KthNodeCoreCore(node.left, k);
        if(target == null){
            if(k[0] == 1)
                target = node;
            k[0]--;
        }
        if(target == null)
            target = KthNodeCoreCore(node.right, k);
        return target;
    }
}
