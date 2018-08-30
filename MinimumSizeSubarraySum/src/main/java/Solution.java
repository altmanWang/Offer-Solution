import java.util.LinkedList;
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        LinkedList<Integer> lists =new LinkedList<Integer>();
        int cnt = 0;
        int min_size = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            lists.addLast(nums[i]);
            cnt += nums[i];
            if(cnt >= s){
                while(lists.size() >=1 && cnt- lists.getFirst() >= s){
                    cnt -= lists.removeFirst();
                }
                min_size = Math.min(min_size, lists.size());
            }

        }
        if(min_size == Integer.MAX_VALUE)
            return 0;
        return min_size;
    }
    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new Solution().minSubArrayLen(7,nums));
    }
}