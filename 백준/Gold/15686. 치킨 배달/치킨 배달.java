import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static int[][] map;
    private static boolean[] visited;
    private static List<int[]> chickens = new ArrayList<>();
    private static List<int[]> houses = new ArrayList<>();
    private static List<int[]> pickedChickens = new ArrayList<>();
    private static int minChickenDist = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ;j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1){
                    houses.add(new int[]{i,j});
                }
                if(map[i][j] == 2){
                    chickens.add(new int[]{i,j});
                }
            }
        }
        visited = new boolean[chickens.size()];
        dfs(0,0);
        System.out.println(minChickenDist);
    }

    private static void dfs(int depth, int start){
        if(depth == m){
            int sum = 0;
            for (int[] house : houses) {
                int min = Integer.MAX_VALUE;
                for (int[] pickedChicken : pickedChickens) {
                    int dist = Math.abs(house[0] - pickedChicken[0]) + Math.abs(house[1] - pickedChicken[1]);
                    min = Math.min(min, dist);
                }
                sum += min;
            }
            minChickenDist = Math.min(minChickenDist, sum);
            return;
        }
        for(int i = start; i < chickens.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                pickedChickens.add(chickens.get(i));
                dfs(depth + 1, i + 1);
                visited[i] = false;
                pickedChickens.remove(pickedChickens.size() - 1);
            }
        }
    }



}
