import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n,m;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map =  new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = true;
                dfs(i , j , 0, map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);

    }

    private static void dfs(int x, int y, int depth, int sum){
        if(depth == 3){
            max =  Math.max(max, sum);
            return;
        }
        for(int i = 0; i < 4; i++){
            int nextX =  x + dx[i];
            int nextY =  y + dy[i];
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m){
                continue;
            }
            if(!visited[nextX][nextY]){

                if(depth == 1){
                    visited[nextX][nextY] = true;
                    dfs(x, y, depth + 1, sum + map[nextX][nextY]);
                    visited[nextX][nextY] = false;
                }

                visited[nextX][nextY] = true;
                dfs(nextX, nextY, depth + 1, sum + map[nextX][nextY]);
                visited[nextX][nextY] = false;
            }
        }
    }

}