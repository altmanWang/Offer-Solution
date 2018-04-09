import java.util.List;
import java.util.LinkedList;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return lists;
        subsets(nums, 0, lists, new LinkedList<Integer>());
        return lists;
    }
    public void subsets(int[] nums, int start, List<List<Integer>> lists, LinkedList<Integer> path){
        lists.add(new LinkedList<Integer>(path));
        for(int i = start; i < nums.length; i++){
            path.addLast(nums[i]);
            subsets(nums,i+1,lists,path);
            path.removeLast();
        }
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> lists  = new Solution().subsets(nums);
        System.out.println(lists);
    }
}