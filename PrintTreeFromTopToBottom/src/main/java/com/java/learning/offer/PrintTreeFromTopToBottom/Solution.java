package com.java.learning.offer.PrintTreeFromTopToBottom;
import java.util.ArrayList;
import java.util.LinkedList;
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if(root == null)
            return results;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tmp = queue.pollFirst();
            results.add(tmp.val);

            if(tmp.left != null)
                queue.add(tmp.left);
            if(tmp.right != null)
                queue.add(tmp.right);
        }
        return results;
    }
}