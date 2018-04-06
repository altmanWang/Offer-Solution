class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        int[][] count = new int[m][n];
        for(int i =0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0)
                    count[i][j] = 1;
                if(j > 0)
                    count[i][j] += count[i][j-1];
                if(i > 0)
                    count[i][j] += count[i-1][j];
            }
        }

        return count[m-1][n-1];
    }
    public static void main(String[] args){
        System.out.println(new Solution().uniquePaths(3,4));
    }
}