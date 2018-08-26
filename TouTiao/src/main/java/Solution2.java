import java.util.*;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }
public class Solution2 {
    public void mergeInterval(List<Interval> lists){
        Collections.sort(lists, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        LinkedList<Interval> res = new LinkedList<Interval>();
        for(Interval interval : lists){
            if(res.isEmpty() || res.get(res.size() - 1).end < interval.start){
                res.add(interval);
            }else{
                res.get(res.size() - 1).end = Math.max(interval.end, res.get(res.size() - 1).end);
            }
        }
        int cnt = 0;
        for(Interval interval : res){
            System.out.print(interval.start + "," + interval.end);
            cnt +=1;
            if(cnt != res.size())
                System.out.print(";");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = Integer.parseInt(sc.nextLine());
            String str;
            List<Interval> list = new LinkedList<Interval>();
            for(int i = 0; i < N; i++){
                str = sc.nextLine();
                String[] strs1 = str.split(";");
                String[] strs2;
                for(int j = 0; j < strs1.length; j++){
                    strs2 = strs1[j].split(",");
                    list.add(new Interval(Integer.parseInt(strs2[0]), Integer.parseInt(strs2[1])));
                }
            }
            new Solution2().mergeInterval(list);
        }
    }
}
