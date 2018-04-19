import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Solution {
    public static int[] core(int[] nums1, int[] nums2){
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        List<Integer> lists = new LinkedList<Integer>();
        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] == nums2[index2]){
                lists.add(nums1[index1]);
                index1 +=1;
                index2 +=1;
                if(index1 < nums1.length && index2 < nums2.length && nums1[index1] == nums1[index1-1] && nums1[index1] == nums2[index2]){
                    index1 +=1;
                    index2 +=1;
                }
            }else if(nums1[index1] < nums2[index2]){
                index1 +=1;
            }else{
                index2 +=1;
            }
        }
        int[] res = new int[lists.size()];
        for(int i = 0; i < lists.size(); i++){
            res[i] = lists.get(i);
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums1 = {2,1,3,10,9,8};
        int[] nums2 = {0,2,3,10};
        int[] res = core(nums1, nums2);
        for(int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
    }
}
