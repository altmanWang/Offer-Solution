public class Solution {
    public static int findGreatestSumOfSubArray(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;

        int[] curSum = new int[nums.length];
        curSum[0] = nums[0];
        int maxSum = curSum[0];
        for(int i = 1 ; i < nums.length; i++){
            if (curSum[i-1] <= 0)
                curSum[i] = nums[i];
            else
                curSum[i] = curSum[i-1] + nums[i];
            if(maxSum < curSum[i])
                maxSum = curSum[i];
        }
        return maxSum;
    }
    public static void main(String[] args){
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] data2 = {-2, -8, -1, -5, -9};
        int[] data3 = {2, 8, 1, 5, 9};
        System.out.println(findGreatestSumOfSubArray(data));
        System.out.println(findGreatestSumOfSubArray(data2));
        System.out.println(findGreatestSumOfSubArray(data3));
    }
}
