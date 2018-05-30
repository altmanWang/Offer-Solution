import java.util.LinkedList;
import java.util.List;
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();
        if(s == null || s.length() == 0 || s.length() < 4 || s.length() > 12)
            return res;
        restoreIpAddresses(s, s.length(), res, 4, "");
        return res;
    }
    public void restoreIpAddresses(String str, int start, List<String> res, int flag, String ip){
        if(flag == 0) {
            if((ip.length() - 4 ) == str.length())
                res.add(ip.substring(0, ip.length() - 1));
            return;
        }
        System.out.println(ip);
        for(int i = 1; i <= Math.min(3,start) ;i++){
            String tmp =  str.substring(start - i, start);

            if((flag != 1) && ((start - i) / (flag-1) > 3 || (start - i) / (flag-1)  < 1))
                continue;
            if(tmp.length() >= 2 && tmp.charAt(0)=='0')
                continue;
            if(Integer.parseInt(tmp) <= 255)
                restoreIpAddresses(str, start - i, res, flag - 1, tmp +"."+ ip);
        }
    }
    public static void main(String[] args){
        System.out.println(new Solution().restoreIpAddresses("101023"));
    }
}