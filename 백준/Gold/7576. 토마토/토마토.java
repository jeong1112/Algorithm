import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dX = {-1,1,0,0};
    static int[] dY = {0,0,-1,1};
    static int n,m;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        System.out.println(bfs());

    }

    private static int bfs(){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0 ; i < 4 ; i++){
                int nX = x + dX[i];
                int nY = y + dY[i];
                if(nX < 0 || nX >= n || nY < 0 || nY >= m) continue;
                if(graph[nX][nY] == 0){
                    graph[nX][nY] = graph[x][y] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }
        }
        if(isZero()){
            return -1;
        }
        int temp = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(graph[i][j] > temp){
                    temp = graph[i][j];
                }
            }
        }
        return temp - 1;
    }



    private static boolean isZero(){
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(graph[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
