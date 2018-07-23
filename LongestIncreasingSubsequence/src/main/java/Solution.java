

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        int[] dp = new int[nums.length];
        int size = 0;
        for(int i = 0; i < nums.length; i++){
            int left = 0;
            int right = size;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(dp[mid] == nums[i]){
                    right = mid;
                    break;
                }
                if(dp[mid] < nums[i]) left = mid + 1;
                else right = mid;
            }
            if(right >= size)
                size +=1;
            dp[right] = nums[i];
        }
        return size;
    }
    public static void main(String[] args){
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}