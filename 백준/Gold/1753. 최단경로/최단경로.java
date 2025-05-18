import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node>[] graph;
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        graph = new List[v+1];
        distance = new int[v+1];
        for(int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < e ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to,weight));
        }
        Arrays.fill(distance, INF);
        dijkstra(start);
        for (int i = 1 ; i <= v ; i++) {
            if(distance[i] == INF) System.out.println("INF");
            else System.out.println(distance[i]);
        }

    }

    static void dijkstra(int start){
        distance[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start,0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            int curIdx = cur.index;
            int curWeight = cur.weight;
            if (distance[curIdx] < curWeight) continue;
            for(Node n : graph[curIdx]){
                int nextIdx = n.index;
                int cost = n.weight + distance[curIdx];
                if(distance[nextIdx] > cost){
                    distance[nextIdx] = cost;
                    q.add(new Node(nextIdx,cost));
                }

            }
        }

    }

    static class Node implements Comparable<Node>{
        int index;
        int weight;

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