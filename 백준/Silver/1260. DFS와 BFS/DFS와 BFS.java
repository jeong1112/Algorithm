import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] graph;
    static int n, m, v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        visited = new boolean[n + 1];
        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);




    }
    static void bfs(int i){
        System.out.print(i + " ");
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int j = 1 ; j < graph.length ; j++){
                if(graph[cur][j] == 1 && !visited[j]){
                    q.add(j);
                    visited[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }

    static void dfs(int i){
        System.out.print(i + " ");
        visited[i] = true;
        if(i == graph.length){
            return;
        }
        for(int j = 1 ; j < graph.length ; j++){
            if(graph[i][j] == 1 && !visited[j]){
                dfs(j);
            }
        }
    }




}
