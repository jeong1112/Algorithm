import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static List<Node>[] graph;
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, 1));
        }

        distance = new int[N + 1];
        Arrays.fill(distance, INF);

        dijkstra(X);

        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currIdx = current.index;
            int currDist = current.weight;

            if (currDist > distance[currIdx]) continue;

            for (Node n : graph[currIdx]) {
                int nextIdx = n.index;
                int cost = distance[currIdx] + n.weight;

                if (cost < distance[nextIdx]) {
                    distance[nextIdx] = cost;
                    pq.offer(new Node(nextIdx, cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int index, weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}