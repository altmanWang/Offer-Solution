public class MathEleInTwoArray {
    static class TreeNode{
        int mid;
        int start;
        int end;
        TreeNode left;
        TreeNode right;
        public TreeNode(int start, int end, int mid){
            this.start = start;
            this.end = end;
            this.mid = mid;
        }
    }
    //        int[] B = {10,7,6,8,9};
    public static int partition(int[] nums, int left, int right, int ele){
        int i = left - 1;
        int j = right + 1;
        int idx = -1;
        int tmp;
        while (i < j){
            while (ele > nums[++i]) if(i >= right) break;
            while (nums[--j] > ele) if(j <= left) break;
            if(i >= j){
                break;
            }
            if(nums[j] == ele)
                idx = i;
            tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
        if(idx != -1){
            tmp = nums[j];
            nums[j] = nums[idx];
            nums[idx] = tmp;
        }
        return j;
    }
    public static int sort(int[] nums, int left, int right, int target){
        int j = partition(nums, left, right, target);

        if(nums[j] == target)
            return j;
        if(nums[j] > target)
            return sort(nums, left, j - 1, target);
        return sort(nums, j + 1, right, target);
    }
    public static void searchTree(TreeNode node, int[] nums, int target){

        if(node == null)
            return;
        int mid = node.mid;
        int start = node.start;
        int end = node.end;
        if(nums[mid] > target){
            if(node.left == null){
                node.left = new TreeNode(start, end, sort(nums, start, mid-1, target));
                System.out.println(nums[node.left.mid]+":"+target);
            }else
                searchTree(node.left, nums, target);
        }else{
            if(node.right == null){
                node.right = new TreeNode(start, end, sort(nums, mid+1, end, target));
                System.out.println(nums[node.right.mid]+":"+target);
            } else
                searchTree(node.right, nums, target);
        }
    }
    public static void matchEle(int[] A, int[] B){
        int j = sort(B, 0, A.length - 1, A[0]);
        TreeNode root = new TreeNode(0, A.length - 1, j);
        System.out.println(A[0]+":"+B[j]);
        for(int i = 1; i < A.length; i++){
            searchTree(root, B, A[i]);
        }
    }
    public static void main(String[] args){
        int[] B = {5,10,7,6,8,9,2,3,1,4,0,-10};
        int[] A = {9,7,8,6,10,3,2,4,5,1,0,-10};
        matchEle(A, B);
        System.out.println();
        for(int i = 0; i < B.length; i++){
            System.out.print(B[i] + " ");
        }
    }
}
