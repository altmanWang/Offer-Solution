package com.java.learning.offer;

/**
 * Created by altman on 18-2-12.
 */
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> path = new Stack<TreeNode>();
        FindPath(root,target, path, results);
        return results;
    }
    public void FindPath(TreeNode node, int target, Stack<TreeNode> path, ArrayList<ArrayList<Integer>> results){
        if(node == null)
            return;
        if(node.val > target)
            return;
        if((node.val - target) == 0 && node.left == null && node.right == null){
            ArrayList<Integer> result = new ArrayList<Integer>();
            for(TreeNode i : path){
                result.add(i.val);
            }
            result.add(node.val);
            results.add(result);
            return;
        }
        path.add(node);
        target = target - node.val;
        FindPath(node.left, target, path, results);
        FindPath(node.right, target, path, results);
        path.pop();
    }
}
