import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int n, m, r;

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

        bfs(r);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        int count = 0;
        int[] result = new int[n + 1];
        result[start] = ++count;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    result[next] = ++count;
                }
            }
        }
        for(int i = 1 ; i <= n; i++) {
            System.out.println(result[i]);
        }
    }
}
