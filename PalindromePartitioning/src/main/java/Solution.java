import java.util.List;
import java.util.LinkedList;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> lists= new LinkedList<List<String>>();
        if(s == null || s.length() == 0)
            return lists;
        partition(s, lists, new LinkedList<String>(), 0);
        return lists;
    }
    public void partition(String s, List<List<String>> lists, LinkedList<String> path, int i){
        if(i >= s.length()){
            lists.add(new LinkedList<String>(path));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(isPalindrome(s, i, j)){
                path.addLast(s.substring(i,j+1));
                partition(s, lists, path, j+1);
                path.removeLast();
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        if(start < 0 || end >= s.length())
            return false;
        int i = start;
        int j = end;

        while(i <= end && j >= start){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i +=1;
            j -= 1;
        }
        return true;
    }
}