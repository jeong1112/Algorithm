import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dX = {1,2,2,1,-1,-2,-2,-1};
    static int[] dY = {2,1,-1,-2,-2,-1,1,2};
    static int[][] arr;
    static int width;
    static boolean[][] visited;
    static int toX,toY;
    public static void main(String[] args)throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int t = Integer.parseInt(br.readLine());
      for (int i = 0; i < t; i++) {
          width = Integer.parseInt(br.readLine());
          arr = new int[width][width];
          visited = new boolean[width][width];
          st = new StringTokenizer(br.readLine());
          int curX = Integer.parseInt(st.nextToken());
          int curY = Integer.parseInt(st.nextToken());
          st = new StringTokenizer(br.readLine());
          toX = Integer.parseInt(st.nextToken());
          toY = Integer.parseInt(st.nextToken());
          bfs(curX,curY);
          System.out.println(arr[toX][toY]);

      }

    }
    private static void bfs(int x, int y){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            for(int i = 0 ; i < 8 ; i++){
                int nextX = nowX + dX[i];
                int nextY = nowY + dY[i];
                if(nextX >=0 && nextY >=0 && nextX < width && nextY < width){
                    if(!visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        q.add(new int[]{nextX,nextY});
                        arr[nextX][nextY] = arr[nowX][nowY] + 1;
                    }
                }
            }
        }

    }

}
