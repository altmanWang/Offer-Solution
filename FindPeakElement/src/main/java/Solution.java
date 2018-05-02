class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        int[] results = {-1};
        findPeakElement(nums, 0, nums.length - 1, results);
        return results[0];
    }
    public void findPeakElement(int[] nums, int start, int end, int[] res){
        if(start > end)
            return;
        int mid = start + (end - start) / 2;
        if((mid == 0 || nums[mid] > nums[mid-1]) && (mid==nums.length-1 || nums[mid] > nums[mid+1])){
            res[0] = mid;
            return;
        }
        if(mid == 0 || nums[mid] > nums[mid-1])
            findPeakElement(nums, mid+1, end, res);
        else
            findPeakElement(nums, start, mid-1, res);
    }

    public static void main(String[] args){
        int[] nums = {3,4,3,2,1};
        System.out.println(new Solution().findPeakElement(nums));
    }
}