public class MaxDiff {
    public static int cmpMaxDiff(int[] nums){
        int max_diff = Integer.MIN_VALUE;
        int max_val = nums[0];
        for(int i = 1; i < nums.length; i++){
            max_diff = max_diff > max_val - nums[i] ? max_diff : max_val - nums[i];
            max_val = max_val > nums[i] ? max_val : nums[i];
        }
        return max_diff;
    }
    public static void main(String[] args){
        int[] nums = {10,2,-10,20,8,9,3,16};
        System.out.println(cmpMaxDiff(nums));
    }
}
