import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dX = {-1,1,0,0};
    private static int[] dY = {0,0,-1,1};
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int maxHeight = 0;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > maxHeight)
                    maxHeight = map[i][j];
            }
        }
        int maxArea = 0;
        for(int height=0; height < maxHeight+1; height++) {
            visited = new boolean[n][n];
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && map[i][j] > height){
                        cnt += dfs(i,j,height);
                    }

                }
            }
            maxArea = Math.max(maxArea, cnt);
        }
        System.out.println(maxArea);
    }
    private static int dfs(int x, int y, int height) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + dX[i];
            int ny = y + dY[i];

            if(nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny]> height) {
                dfs(nx,ny, height);
            }
        }
        return 1;
    }






}