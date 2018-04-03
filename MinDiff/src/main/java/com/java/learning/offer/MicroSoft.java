package com.java.learning.offer;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}

public class MicroSoft {
    public int method(int numNodes, int rootNode, int[] values, int[][] edges){
        TreeNode[] nodes = new TreeNode[numNodes];
        for(int i = 0; i < numNodes; i++){
            nodes[i] = new TreeNode(values[i]);
        }
        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0]-1;
            int tar = edges[i][1]-1;
            if(nodes[src].left==null)
                nodes[src].left = nodes[tar];
            else if(nodes[src].right==null)
                nodes[src].right = nodes[tar];
        }
        TreeNode root = nodes[rootNode-1];
        LinkedList<Integer> scores =  new LinkedList<Integer>();
        int[] cur_score = {1};
        dfs(root, scores, cur_score);
        Collections.sort(scores);
        return scores.getLast();
    }
    public void dfs(TreeNode node, LinkedList<Integer> scores, int[] cur_score){
        cur_score[0] = cur_score[0] * node.val;
        if(node.left == null && node.right == null){
            scores.add(cur_score[0]);
        }
        if(node.left != null)
            dfs(node.left, scores, cur_score);
        if(node.right != null)
            dfs(node.right, scores, cur_score);
        cur_score[0] = cur_score[0] / node.val;
    }
    public static void main(String[] args){
        int numNodes = 5;
        int rootNode = 1;
        int[] values = {2,4,10,20,1};
        int[][] edges = {{1,2},{1,3},{2,4},{2,5}};

        System.out.println(new MicroSoft().method(numNodes, rootNode, values, edges));
    }
}
