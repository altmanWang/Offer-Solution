public class Solution {
    public static int maxSumOfSubMatrix(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int[] nums = new int[m];
            for(int j = i; j < n; j++){
                int sum = 0;
                for(int k = 0; k < m; k++){
                    nums[k] += matrix[j][k];
                    sum += nums[k];
                    if(sum < 0) sum = nums[k];
                    if(sum > max) max = sum;
                }
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[][] matrix = {{0,-2,-7,0},
                           {9,2,-6,2},
                           {-4,1,-4,1},
                           {-1,8,0,-2}};
        System.out.println(maxSumOfSubMatrix(matrix));

    }
}
