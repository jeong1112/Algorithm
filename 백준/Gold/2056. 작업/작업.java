import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] edgeCount = new int[n + 1];
        int[] workTime = new int[n + 1];
        int[] finishTime = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            workTime[i] = time;

            for (int j = 0; j < k; j++) {
                int neighbor = Integer.parseInt(st.nextToken());
                edgeCount[i]++;
                graph.get(neighbor).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (edgeCount[i] == 0) {
                q.offer(i);
                finishTime[i] = workTime[i];
            }
        }

        int totalTime = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            totalTime = Math.max(totalTime, finishTime[node]);
            List<Integer> neighbors = graph.get(node);

            for (int i = 0; i < neighbors.size(); i++) {
                int neighbor = neighbors.get(i);
                edgeCount[neighbor]--;
                finishTime[neighbor] = Math.max(finishTime[neighbor], finishTime[node] + workTime[neighbor]);

                if (edgeCount[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        System.out.println(totalTime);
    }

}