import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int count;
    static int n;
    static boolean[][] visited;
    static List<Integer> result;
    static int[][] matrix;
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        count = 1;
        visited = new boolean[n][n];
        matrix = new int[n][n];
        result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 1 && !visited[i][j]) {
                    dfs(i,j);
                    result.add(count);
                    count = 1;
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }


    }

    private static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0 ; i < dX.length ; i++){
            int newX = x + dX[i];
            int newY = y + dY[i];

            if(newX >=0 && newY >= 0 && newX < n && newY < n && !visited[newX][newY] && matrix[newX][newY] == 1){
                count++;
                dfs(newX, newY);
            }
        }


    }



}
