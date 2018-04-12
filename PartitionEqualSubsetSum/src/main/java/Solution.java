class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        int sum_value = 0;
        for(int i = 0; i < nums.length; i++){
            sum_value += nums[i];
        }
        if(sum_value % 2 == 1)
            return false;
        return canPartition(sum_value / 2, nums);
    }
    public boolean canPartition(int target, int[] nums){
        int[][] values = new int[nums.length+1][target+1];
        for(int i = 1; i < values.length; i++){
            for(int j = 0; j < values[0].length; j++){
                if(j < nums[i-1])
                    continue;
                values[i][j] = Math.max(values[i-1][j], values[i-1][j-nums[i-1]] + nums[i-1]);
            }
        }
        if(values[nums.length][target] == target)
            return true;
        return false;
    }
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 5};
        System.out.println(new Solution().canPartition(nums));
    }
}