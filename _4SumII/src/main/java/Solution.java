import java.util.HashMap;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        int len = A.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                maps.put(A[i] + B[j], maps.getOrDefault(A[i] + B[j], 0)+1);
            }
        }
        int res = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                int tmp = -(C[i] + D[j]);
                res += maps.getOrDefault(tmp,0);
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};
        System.out.println(new Solution().fourSumCount(A,B,C,D));
    }

}