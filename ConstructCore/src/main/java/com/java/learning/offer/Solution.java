package com.java.learning.offer;

public class Solution {
    public BinaryTreeNode Construct(int[] preorder, int[] inorder){
        if(preorder==null || inorder==null)
            return null;
        BinaryTreeNode root;
        int startPreorder = 0;
        int endPreorder = preorder.length-1;

        int startinorder = 0;
        int endinorder = inorder.length-1;

        root = ConstructCore(preorder, inorder, startPreorder, endPreorder, startinorder, endinorder);

        return root;
    }
    public BinaryTreeNode ConstructCore(int[] preorder, int[] inorder, int startPreorder, int endPreorder, int startinorder, int endinorder){
        if(startPreorder > endPreorder){
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(preorder[startPreorder]);
        int index = startinorder;
        while (index < endinorder){
            if(inorder[index] == preorder[startPreorder]){
                break;
            }
            index += 1;
        }
        int leftPreorderEnd = startPreorder + index  - startinorder;
        if(index - 1  - startinorder >= 0){
            root.leftNode = ConstructCore(preorder, inorder, startPreorder+1, leftPreorderEnd, startinorder, index-1 );
        }
        if((endinorder - index -1 ) >= 0){
            root.rightNode = ConstructCore(preorder, inorder, leftPreorderEnd+1, endPreorder, index+1, endinorder);
        }

        return root;
    }
}
