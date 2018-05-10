class Solution {
    public int repeatedStringMatch(String A, String B) {
        if(B == null || A == null)
            return -1;
        StringBuilder tmp = new StringBuilder(A);
        int res = 1;
        while(tmp.length() < B.length()){
            tmp.append(A);
            res +=1;
        }
        if(tmp.toString().contains(B))
            return res;
        tmp.append(A);
        res +=1;
        if(tmp.toString().contains(B))
            return res;
        return -1;

    }
    public static void main(String[] args){
        String A = "abcd";
        String B = "cdabcdab";
        System.out.println(new Solution().repeatedStringMatch(A, B));
    }
}