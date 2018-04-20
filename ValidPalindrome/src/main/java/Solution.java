class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(left < right && (s.charAt(left) - 'a' < 0 || s.charAt(left) - 'a' > 26) && (s.charAt(left) - '0' < 0 || s.charAt(left) - '0' > 9))
                left +=1;
            while(left < right && (s.charAt(right) - 'a' < 0 || s.charAt(right) - 'a' > 26)&& (s.charAt(right) - '0' < 0 || s.charAt(right) - '0' > 9))
                right -=1;

            if(left < right && s.charAt(left)  != s.charAt(right))
                return false;
            left +=1;
            right -=1;
        }
        return true;
    }
    public static void main(String[] args){
        String s = "OP";
        System.out.println(new Solution().isPalindrome(s.toLowerCase()));

    }
}