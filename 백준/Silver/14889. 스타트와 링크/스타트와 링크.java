import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] map;
    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        visited = new boolean[n];
        map = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int depth, int index){
        if(depth == n / 2){
            int start = 0;
            int link = 0;
            for(int i = 0 ; i < n - 1 ; i++){
                for(int j = i + 1 ; j < n ; j++){

                    if(visited[i] && visited[j]){
                        start += map[i][j] + map[j][i];
                    }

                    else if(!visited[i] && !visited[j]){
                        link += map[i][j] + map[j][i];
                    }
                }
            }
            int result = Math.abs(start - link);
            if(result == 0){
                System.out.println(result);
                System.exit(0);
            }
            min = Math.min(result, min);
            return;
        }

       for(int i = index ; i < n ; i++) {
           if(!visited[i]) {
               visited[i] = true;
               dfs(depth + 1, i + 1);
               visited[i] = false;
           }
       }

    }


}
