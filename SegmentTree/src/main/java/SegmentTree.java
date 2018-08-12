public class SegmentTree {
    class TreeNode{
        int l, r;
        int val;
        int min_val, max_val;
        TreeNode left_node, right_node;
        public TreeNode(int l, int r){
            this.l = l;
            this.r = r;
        }
    }
    public TreeNode buildSegmentTree(int[] nums, int left, int right){

        if(left >= right){
            TreeNode leaf = new TreeNode(left, right);
            leaf.val = nums[left];
            leaf.min_val = nums[left];
            leaf.max_val = nums[left];
            return leaf;
        }

        TreeNode node = new TreeNode(left, right);
        int mid = left + (right - left) / 2;
        node.left_node = buildSegmentTree(nums, left, mid);
        node.right_node = buildSegmentTree(nums, mid + 1, right);

        node.min_val = Math.min(node.left_node.min_val, node.right_node.min_val);
        node.max_val = Math.max(node.left_node.max_val, node.right_node.max_val);

        return node;
    }
    public static void searchSegmentTree(TreeNode node, int left, int right, int[] res){
        if(node == null)
            return;
        if(left == node.l && right == node.r){
            System.out.println(left + " " + right);
            System.out.println("min:" + node.min_val);
            res[0] = Math.min(res[0], node.min_val);
            return;
        }
        int mid = node.l + (node.r - node.l) / 2;
        if(mid >= right){
            searchSegmentTree(node.left_node, left, right, res);
        }else if(mid < left){
            searchSegmentTree(node.right_node, left, right, res);
        }else if(mid >= left && mid <= right){
            searchSegmentTree(node.left_node, left, mid, res);
            searchSegmentTree(node.right_node, mid +1, right, res);
        }
    }
    public static void main(String[] args){
        int[] nums = {3,-10,2,3,10,-100,2,3};
        TreeNode root = new SegmentTree().buildSegmentTree(nums, 0, nums.length - 1);
        int[] tmp = new int[1];
        tmp[0] = Integer.MAX_VALUE;
        searchSegmentTree(root, 1 , 7, tmp);
        System.out.println(tmp[0]);

    }
}
