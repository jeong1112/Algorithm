import java.io.*;
import java.util.*;

public class Main {
    static int N, D;
    static ArrayList<Node>[] graph;
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        graph  = new ArrayList[10001];
        distance = new int[10001];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
            distance[i] = i;
        }
        distance[0] = 0;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int from  = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
        }
        dijkstra(0);
        System.out.println(distance[D]);
    }
    private static void dijkstra(int start){
        if(start > D){
            return;
        }
        if(distance[start + 1] > distance[start] + 1){
            distance[start + 1] = distance[start] + 1;
        }
        for (Node node : graph[start]) {
            if (distance[start] + node.weight < distance[node.index]) {
                distance[node.index] = distance[start] + node.weight;
            }
        }
        dijkstra(start + 1);
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