import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int n, m, r;
    static int[] result;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];
        result = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i = 1 ; i < n; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(r);
        for(int i = 1; i < n + 1; i++) {
            System.out.println(result[i]);
        }
    }

    static void dfs(int start) {
        visited[start] = true;
        result[start] = ++count;
        for(int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if(!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
