import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static char[][] map;
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {-1, 1, 0, 0};
    static int n,m;
    static int count = 0;
    static int startX,startY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'I'){
                    startX = i;
                    startY = j;
                }
            }
        }
        dfs(startX, startY);
        if(count == 0){
            System.out.println("TT");
            return;
        }
        System.out.println(count);

    }
    private static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0 ; i < 4 ; i++){
            int nX = x + dX[i];
            int nY = y + dY[i];
            if(nX >= 0 && nY >= 0 && nX < n && nY < m && !visited[nX][nY] && map[nX][nY] != 'X'){
                if(map[nX][nY] == 'P'){
                    count++;
                }
                dfs(nX, nY);
            }

        }
    }
}
