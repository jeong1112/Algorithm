import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dX = {-1,1,0,0};
    static int[] dY = {0,0,-1,1};
    static int n,m;
    static int[][] map;
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();

    }

    private static void bfs() {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0,0,1,false));
        while(!q.isEmpty()){
            Position now =  q.poll();
            if(now.x == n - 1 && now.y == m - 1){
                System.out.println(now.count);
                return;
            }

            for(int i = 0 ; i < 4 ; i++){
                int nx =  now.x + dX[i];
                int ny =  now.y + dY[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                int nextCnt = now.count + 1;
                if(map[nx][ny] == 0){
                    if(!now.wall && !visited[nx][ny][0]){
                        q.add(new Position(nx, ny, nextCnt, false));
                        visited[nx][ny][0] = true;
                    }
                    else if(now.wall && !visited[nx][ny][1]){
                        q.add(new Position(nx, ny, nextCnt, true));
                        visited[nx][ny][1] = true;
                    }
                }
                else if(map[nx][ny] == 1){
                    if(!now.wall){
                        q.add(new Position(nx, ny, nextCnt, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class Position{
        int x;
        int y;
        int count;
        boolean wall;

        public Position(int x, int y, int count, boolean wall) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.wall = wall;
        }
    }



}