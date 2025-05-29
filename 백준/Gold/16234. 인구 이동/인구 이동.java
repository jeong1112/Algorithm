import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dX = {-1,1,0,0};
    static int[] dY = {0,0,-1,1};
    static int N,L,R;
    static int count = 0;
    static boolean [][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            visited = new boolean[N][N];
            boolean hasUnion = false;
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(!visited[i][j]){
                        List<int[]> union = bfs(i, j);
                        if(union.size() > 1){
                            hasUnion = true;
                            int sum = 0;
                            for (int[] ints : union) {
                                sum += map[ints[0]][ints[1]];
                            }
                            int newPopulation = sum / union.size();
                            for (int[] ints : union) {
                                map[ints[0]][ints[1]] = newPopulation;
                            }
                        }
                    }
                }
            }

            if(!hasUnion) break;
            count++;

        }
        System.out.println(count);
    }
    private static List<int[]> bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        union.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int i = 0; i < 4; i++){
                int newX = curX + dX[i];
                int newY = curY + dY[i];
                if(newX < 0 || newX >= N || newY < 0 || newY >= N) continue;
                if(visited[newX][newY]) continue;

                int populationDiff = Math.abs(map[curX][curY] - map[newX][newY]);
                if(populationDiff >= L && populationDiff <= R){
                    visited[newX][newY] = true;
                    union.add(new int[]{newX,newY});
                    q.add(new int[]{newX,newY});
                }
            }
        }
        return union;
    }


}
