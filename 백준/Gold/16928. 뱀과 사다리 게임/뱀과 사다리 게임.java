import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Queue<Integer> q = new LinkedList<>();
    private static Map<Integer, Integer> map = new HashMap<>();
    private static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map.put(from, to);
        }

        bfs();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int pos = current[0];
            int cnt = current[1];

            for (int i = 1; i <= 6; i++) {
                int next = pos + i;
                if (next > 100) continue;
                if (map.containsKey(next)) {
                    next = map.get(next);
                }

                if (!visited[next]) {
                    if (next == 100) {
                        System.out.println(cnt + 1);
                        return;
                    }

                    visited[next] = true;
                    q.add(new int[]{next, cnt + 1});
                }
            }
        }
    }
}