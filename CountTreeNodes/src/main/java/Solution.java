class TreeNode{
    TreeNode left = null;
    TreeNode right = null;
    int val = 0;
    public TreeNode(){}
}
public class Solution {
    public static void countNodeNum(TreeNode node){
        core(node);
    }
    public static int core(TreeNode node){
        if(node == null)
            return 0;
        node.val = core(node.left) + core(node.right);
        return node.val + 1;
    }
    public static void printTree(TreeNode node){
        if(node == null)
            return;
        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode();
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();

        root.left = left;
        root.right = right;

        left = new TreeNode();
        right = new TreeNode();

        root.left.left = left;
        root.left.right = right;

        left = new TreeNode();

        root.right.left = left;

        left = new TreeNode();
        root.left.left.left = left;

        countNodeNum(root);
        printTree(root);
    }
}
