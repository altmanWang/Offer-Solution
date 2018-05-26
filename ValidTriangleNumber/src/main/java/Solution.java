import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int triangleNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int res = 0;
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 2; i--){
            int start = 0;
            int end = i - 1;
            while(start < end){
                if(nums[start] + nums[end] > nums[i]){
                    res += (end - start);
                    end -=1;
                }else{
                    start +=1;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {24,3,82,22,35,84,19};
        System.out.println(new Solution().triangleNumber(nums));
    }
}