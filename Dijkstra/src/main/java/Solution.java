import java.util.TreeSet;

public class Solution {
    class Dis{
        String path;
        int value;
        boolean visited;
        public Dis(){
            path = "";
            value = 0;
            visited = false;
        }
    }
    public void Dijkstra(int[][] graph, int src, int n){
        Dis[] dis = new Dis[6];
        for(int i = 0; i < n; i++){
            dis[i] = new Dis();
            dis[i].path = "v" + src + "-->v" + i;
            dis[i].value = graph[src][i];
        }
        dis[src].visited = true;
        dis[src].value = 0;
        int cnt = 1;
        while(cnt < n){
            int tmp = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                if(!dis[i].visited && dis[i].value < min){
                    min = dis[i].value;
                    tmp = i;
                }
            }
            dis[tmp].visited = true;
            cnt ++;
            for(int i = 0; i < n; i++){
                if(!dis[i].visited && graph[tmp][i] != Integer.MAX_VALUE && dis[i].value > (graph[tmp][i] + dis[tmp].value) ){
                    dis[i].value = graph[tmp][i] + dis[tmp].value;
                    dis[i].path = dis[tmp].path + "-->v" + i;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(dis[i].value != Integer.MAX_VALUE)
                System.out.println(dis[i].path + " " + dis[i].value);
        }
    }
    public static void main(String[] args){
        int[][] graph = new int[6][6];
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        graph[0][2] = 10;
        graph[0][4] = 30;
        graph[0][5] = 100;
        graph[1][2] = 5;
        graph[2][3] = 50;
        graph[3][5] = 10;
        graph[4][5] = 60;
        graph[4][3] = 20;
        new Solution().Dijkstra(graph, 0, 6);
    }
}
