/*
给定一个有序的数组，计算绝对值不等的元素数目。时间复杂读O(n)，空间复杂度O(1)。
例如：
输入[-2,0,1,2]
输出3
解释：因为-2和2绝对值相等，所以绝对值不等的元素数目为3，（-2,0,1）或者（0,1,2）
 */
public class Solution{
    public int findNumAbsEqu(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        int cnt = nums.length;
        while(left < right){
            int tmpL = nums[left] < 0 ? -nums[left] : nums[left];
            int tmpR = nums[right] < 0 ? -nums[right] : nums[right];
            if(tmpL > tmpR){
                left +=1;
            }else if(tmpR > tmpL){
                right -=1;
            }else{
                left +=1;
                right -=1;
                cnt -=1;
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        int[] nums = {-2,0,1,2};
        System.out.println(new Solution().findNumAbsEqu(nums));
    }
}