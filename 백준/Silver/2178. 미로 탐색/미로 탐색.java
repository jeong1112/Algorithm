import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dX = {-1,1,0,0};
    private static int[] dY = {0,0,-1,1};
    private static int n,m;
    private static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            String input = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        count = 0;
        bfs(0,0);
    }

    private static void bfs(int x, int y){
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(x,y,1));
        visited[x][y] = true;
        while(!q.isEmpty()){
            count++;
            Position now = q.poll();
            int curX = now.getX();
            int curY = now.getY();
            int count = now.getCount();
            if(curX == n-1 && curY == m-1){
                System.out.println(count);
            }
            for(int i = 0; i < 4 ; i++){
                int nX = curX + dX[i];
                int nY = curY + dY[i];
                if(nX < 0 || nX >= n || nY < 0 || nY >= m){
                    continue;
                }
                if(!visited[nX][nY] && map[nX][nY] == 1){
                    q.add(new Position(nX,nY,count+1));
                    visited[nX][nY] = true;
                }
            }
        }
    }

    private static class Position{
        int x;
        int y;
        int count;

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCount() {
            return count;
        }
    }


}