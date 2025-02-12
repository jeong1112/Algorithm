import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dX = {0,0,1,-1};
    static int[] dY = {1,-1,0,0};
    static int n,m;
    static int maxSafeZone = Integer.MIN_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(maxSafeZone);
    }

    private static void dfs(int wall){
        if(wall == 3){
            bfs();
            return;
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(wall+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs(){
        Queue<Position> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 2){
                    q.add(new Position(i, j));
                }
            }
        }
        int[][] copymap = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            copymap[i] = map[i].clone();
        }
        while(!q.isEmpty()){
            Position curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            for(int i = 0; i < 4; i++){
                int nX = x + dX[i];
                int nY = y + dY[i];
                if(nX >= 0 && nX < n && nY >= 0 && nY < m){
                    if(copymap[nX][nY] == 0){
                        q.add(new Position(nX, nY));
                        copymap[nX][nY] = 2;
                    }
                }
            }
        }
        funcSafeZone(copymap);


    }
    private static void funcSafeZone(int[][] copyMap) {
        int safeZone = 0;
        for(int i=0; i<n ; i++) {
            for(int j=0; j<m; j++) {
                if(copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        if (maxSafeZone < safeZone) {
            maxSafeZone = safeZone;
        }
    }

    private static class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
