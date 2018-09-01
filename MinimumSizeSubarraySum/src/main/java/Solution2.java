public class Solution2 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i < sum.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        if(sum[sum.length - 1] < s)
            return 0;
        int tmp;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            tmp = binarySearch(sum, i,i, nums.length, s);
            if(tmp == 0)
                continue;
            res = Math.min(res, tmp - i);
        }
        if(res == Integer.MAX_VALUE)
            return 0;
        return res;
    }
    public int binarySearch(int[] sums, int idx, int left, int right, int target){
        if(left > right)
            return 0;
        int mid = left + (right - left) / 2;
        if(sums[mid] - sums[idx] == target || (sums[mid] - sums[idx] > target && sums[mid - 1] - sums[idx] < target))
            return mid;
        if(sums[mid] - sums[idx] > target)
            return binarySearch(sums, idx, left, mid - 1, target);
        return binarySearch(sums, idx, mid + 1, right, target);

    }
    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new Solution2().minSubArrayLen(7,nums));
    }
}
