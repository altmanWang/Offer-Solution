import java.util.Scanner;

public class Solution1 {
    public void solution(boolean[][] matrix, int N, int M){
        int cnt = 0;
        int max_num = Integer.MIN_VALUE;
        for(int i =0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(matrix[i][j]){
                    cnt +=1;
                    int tmp = solutionCore(matrix, i, j);
                    if(tmp > max_num)
                        max_num = tmp;
                }
            }
        }
        System.out.println(cnt + " "+ max_num);
    }
    public int solutionCore(boolean[][] matrix, int i, int j){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
            return 0;
        if(matrix[i][j]){
            matrix[i][j] = false;
            int num = 1 +  solutionCore(matrix, i - 1, j) +
                    solutionCore(matrix, i + 1, j) +
                    solutionCore(matrix, i, j - 1) +
                    solutionCore(matrix, i, j + 1) +
                    solutionCore(matrix, i - 1, j - 1) +
                    solutionCore(matrix, i - 1, j + 1) +
                    solutionCore(matrix, i + 1, j - 1) +
                    solutionCore(matrix, i + 1, j + 1);
            return num;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str;
            String[] strs;
            str = sc.nextLine();
            strs = str.split(",");
            int N = Integer.parseInt(strs[0]), M = Integer.parseInt(strs[1]);
            boolean[][] matrix = new boolean[N][M];
            for(int i = 0; i < N; i++){
                str = sc.nextLine();
                strs = str.split(",");
                for(int j = 0; j < M; j++){
                    if (Integer.parseInt(strs[j]) == 1)
                        matrix[i][j] = true;
                }
            }
            new Solution1().solution(matrix, N, M);
        }
    }
}
