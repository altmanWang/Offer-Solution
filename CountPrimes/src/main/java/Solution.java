class Solution {
    public int countPrimes(int n) {
        if(n <= 2)
            return 0;
        int res = 0;
        boolean[] maps = new boolean[n+1];

        for(int i = 2; i < ((int)Math.sqrt(n) + 1); i++){
            if(maps[i] == true) continue;
            int p = 2;
            while(p * i < n){
                maps[p * i] = true;
                p +=1;
            }
        }
        for(int i = 2; i < n; i++){
            if(maps[i] == false)
                res +=1;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(new Solution().countPrimes(10));
    }
}