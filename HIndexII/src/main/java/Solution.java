public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        return hIndex(citations, 0, citations.length - 1, citations.length);
    }
    public int hIndex(int[] citations, int start, int end, int length){
        if(start > end)
            return length - start;
        int mid = start + (end - start) / 2;
        if(length - mid == citations[mid])
            return length - mid;
        if(length - mid >= citations[mid])
            return hIndex(citations, mid + 1, end, length);
        else
            return hIndex(citations, start, mid - 1, length);
    }
    public static void main(String[] args){
        int[] nums = {0,1,3,5,6};
        System.out.println(new Solution().hIndex(nums));
    }
}
