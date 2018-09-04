class Solution {
    public int findDuplicate(int[] nums) {
        int swp = 0;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != nums[nums[i] - 1]){
                swp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = swp;
            }
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 != i){
                res = nums[i];
                break;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {1,3,4,2,2};
        System.out.println(new Solution().findDuplicate(nums));
    }
}