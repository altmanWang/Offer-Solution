package com.java.learning.offer.ConvertBinarySearchTree;

/**
 * Created by altman on 18-2-14.
 */

public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        TreeNode DeLinkedList = null;
        TreeNode root = pRootOfTree;
        Convert(root, DeLinkedList);
        while(pRootOfTree!=null && pRootOfTree.left!=null)
            pRootOfTree = pRootOfTree.left;
        return pRootOfTree;
    }
    public TreeNode Convert(TreeNode node, TreeNode DeLinkedList){
        TreeNode current = node;
        if(current.left != null)
            DeLinkedList = Convert(current.left, DeLinkedList);
        current.left = DeLinkedList;
        if(DeLinkedList != null)
            DeLinkedList.right = current;
        DeLinkedList = current;
        if(current.right != null)
            DeLinkedList = Convert(current.right, DeLinkedList);
        return DeLinkedList;
    }
}
