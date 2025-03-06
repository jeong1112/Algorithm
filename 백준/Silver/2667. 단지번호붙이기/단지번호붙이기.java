import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int count = 1;
    static int n;
    static boolean[][] visited;
    static List<Integer> result;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        result = new ArrayList<>();
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    result.add(count);
                    count = 1;
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (Integer i : result) {
            System.out.println(i);
        }


    }
    private static void dfs(int i, int j) {
        visited[i][j] = true;
        for(int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] == 1) {
                count++;
                dfs(nx, ny);
            }
        }
    }



}
