class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word.charAt(0) == board[i][j]){
                    if(exist(board, visited, word, 0, i, j, m, n))
                        return true;
                }
            }
        }
        return false;

    }
    public boolean exist(char[][] board, boolean[][] visited, String word, int start, int i, int j, int m, int n){
        if(start >= word.length())
            return true;
        if(i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && board[i][j] == word.charAt(start)){
            visited[i][j] = true;
            boolean flag =  exist(board, visited, word, start+1, i+1, j, m, n) ||
                    exist(board, visited, word, start+1, i-1, j, m, n) ||
                    exist(board, visited, word, start+1, i, j+1, m, n) ||
                    exist(board, visited, word, start+1, i, j-1, m, n);
            visited[i][j] = false;
            return flag;
        }
        return false;
    }
    public static void main(String[] args){
        char[][] board = {{'a','b'}};
        System.out.println(new Solution().exist(board,"ba"));
    }
}