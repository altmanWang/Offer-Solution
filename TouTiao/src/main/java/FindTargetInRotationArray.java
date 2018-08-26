public class FindTargetInRotationArray {
    public static int findTarget(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[left]){
                if(nums[left] <= target && nums[mid] > target)
                    right = mid - 1;
                else
                    left = mid  + 1;
            }else{
                if(nums[mid] < target && nums[right] >= target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {3,4,5,1,2};
        System.out.println(findTarget(nums, 4));
    }
}
