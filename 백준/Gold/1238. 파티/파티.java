import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,x;
    static List<Node>[] graph;
    static List<Node>[] reverseGraph;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        reverseGraph = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
            reverseGraph[to].add(new Node(from, weight));
        }

        int[] distance = dijkstra(graph, x);
        int[] reverseDistance = dijkstra(reverseGraph, x);

        int result = Integer.MIN_VALUE;
        for(int i = 0; i < distance.length; i++){
            int dist = distance[i] + reverseDistance[i];
            if(dist > result){
                result = dist;
            }
        }
        System.out.println(result);

    }

    static int[] dijkstra(List<Node>[] graph, int start){
        int[] distance = new int[n+1];
        Arrays.fill(distance, INF);
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        distance[start] = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            int currIdx = cur.index;
            for(Node n : graph[currIdx]){
                int nextIdx = n.index;
                int cost = n.weight + distance[currIdx];
                if(cost < distance[nextIdx]){
                    distance[nextIdx] = cost;
                    q.add(new Node(nextIdx, cost));
                }
            }
        }
        return distance;
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
            return weight - o.weight;
        }
    }





}
