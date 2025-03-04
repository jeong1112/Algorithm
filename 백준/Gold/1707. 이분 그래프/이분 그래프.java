import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] colors;
    static boolean isBipartite;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V+1];
            colors = new int[V+1];
            isBipartite = true;
            for(int a = 0; a < V+1; a++) {
                graph[a] = new ArrayList<>();
            }
            for(int j = 0 ; j < E ; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            for(int b = 1 ; b < V+1 ; b++){
                if(!isBipartite){
                    break;
                }
                if(colors[b] == 0){
                    dfs(b,1);
                }
            }
            System.out.println(isBipartite ? "YES" : "NO");
        }

    }

    private static void dfs(int start, int color){
        colors[start] = color;
        for(int v : graph[start]){
            if(colors[v] == color){
                isBipartite = false;
                return;
            }
            if(colors[v] == 0){
                dfs(v, -color);
            }
        }
    }


}
