class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0)
            return 0;
        if(cost.length == 1)
            return cost[0];
        if(cost.length == 2)
            return cost[0] > cost[1] ? cost[1] : cost[0];
        int n = cost.length;
        int[] total_cost = new int[n];
        total_cost[0] = cost[0];
        total_cost[1] = cost[1];
        for(int i = 2; i < n; i++){
            total_cost[i] = cost[i] + (total_cost[i-1] > total_cost[i-2] ? total_cost[i-2] : total_cost[i-1]);
        }
        return total_cost[n-1] > total_cost[n-2] ? total_cost[n-2] : total_cost[n-1];
    }
    public static void main(String[] args){
        int[] nums = {1,1,0,0};
        new Solution().minCostClimbingStairs(nums);
    }
}