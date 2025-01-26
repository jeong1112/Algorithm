import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int k;
    static int min = Integer.MAX_VALUE;
    static final int SIZE = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[SIZE + 1];
        bfs(n);
        System.out.println(min);
    }


    private static void bfs(int x){
        visited[x] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,0));
        while(!q.isEmpty()){
            Node node = q.poll();
            visited[node.x] = true;
            if(node.x == k){
                min = Math.min(min,node.time);
            }
            if(node.x * 2 <= SIZE && !visited[node.x * 2]){
                q.offer(new Node(node.x * 2,node.time));
            }
            if(node.x + 1 <= SIZE && !visited[node.x + 1]){
                q.offer(new Node(node.x + 1,node.time + 1));
            }
            if(node.x - 1 >= 0 && !visited[node.x-1]){
                q.offer(new Node(node.x - 1,node.time + 1));
            }

        }
    }

    private static class Node{
        private int x;
        private int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

}
