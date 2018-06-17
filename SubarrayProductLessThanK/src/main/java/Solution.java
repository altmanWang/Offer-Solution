class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1)
            return 0;
        int pros = 1;
        int j = 0, total = 0;
        for (int i = 0; i < nums.length; i++){
            pros *= nums[i];
            while (pros >= k){
                pros /= nums[j++];
            }
            total += (i - j + 1);
        }
        return total;
    }
    public static void main(String[] args){
        int[] nums = {1,1,1};
        System.out.println(new Solution().numSubarrayProductLessThanK(nums, 2));
    }
}