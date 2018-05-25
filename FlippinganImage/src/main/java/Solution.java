class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length == 0 || A[0] == null || A[0].length == 0)
            return A;
        int m = A.length;
        int n = A[0].length;
        for(int i = 0; i < m; i++){
            if(n%2==1)
                A[i][n/2] = 1 - A[i][n/2];
            for(int j = 0; j < n/2; j++){
                int tmp = 1 - A[i][j];
                A[i][j] = 1 - A[i][n - j - 1];
                A[i][n - j -1] = tmp;
            }
        }
        return A;
    }
    public static void main(String[] args){
        int[][] A = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        A = new Solution().flipAndInvertImage(A);
        for(int i = 0; i < A.length; i ++){
            for(int j = 0; j < A[0].length; j++){
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
    }
}