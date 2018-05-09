import java.util.*;

class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> paths = new LinkedList<String>();
        if(tickets == null || tickets[0] == null)
            return paths;
        HashMap<String, PriorityQueue<String>> maps = new HashMap<String, PriorityQueue<String>>();
        for(int i =0; i < tickets.length; i++){
            PriorityQueue<String> lists;
            if(maps.containsKey(tickets[i][0]))
                lists = maps.get(tickets[i][0]);
            else
                lists = new PriorityQueue<String>();
            lists.add(tickets[i][1]);
            maps.put(tickets[i][0], lists);
        }
        dfs("JFK", maps, paths);
        return paths;
    }
    public void dfs(String str, HashMap<String, PriorityQueue<String>> maps, List<String> lists){
        if(maps.get(str) == null){
            lists.add(0,str);
            return;
        }
        while(maps.get(str).size() > 0){
            String tmp = maps.get(str).poll();
            dfs(tmp, maps, lists);
        }
        lists.add(0,str);
    }
    public static void main(String[] args){
        //String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        String[][] tickets = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        System.out.println(new Solution().findItinerary(tickets));
    }
}