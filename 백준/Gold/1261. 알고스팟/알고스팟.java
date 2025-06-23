import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] map;
    static int[] dX = {-1,1,0,0};
    static int[] dY = {0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        for(int i = 1 ; i < n+1; i++){
            String input = br.readLine();
            for(int j = 0 ; j < m; j++){
                map[i][j+1] = input.charAt(j) - '0';
            }
        }
        bfs(1,1);

    }

    private static void bfs(int x, int y){
        PriorityQueue<Node> q =  new PriorityQueue<>();
        boolean[][] visited =  new boolean[n+1][m+1];
        q.offer(new Node(x,y,0));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.x == n && cur.y == m){
                System.out.println(cur.count);
                return;
            }
            int count = cur.count;
            for(int i = 0; i < 4; i++){
                int nX = cur.x + dX[i];
                int nY = cur.y + dY[i];
                if(nX > 0 && nX <= n && nY > 0 && nY <= m && !visited[nX][nY]){
                    visited[nX][nY] = true;
                    if(map[nX][nY] == 0){
                        q.offer(new Node(nX,nY,count));
                    }
                    else if(map[nX][nY] == 1){
                        q.offer(new Node(nX,nY,count+1));
                    }
                }
            }

        }


    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }



}
