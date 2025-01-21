import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> result;
    static boolean[][] visited;
    static int[][] map;
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {-1, 1, 0, 0};
    static int M, N, K;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            result = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            count = 1;
            visited = new boolean[N][M];
            map = new int[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1; // 수정: x, y 순서를 반대로 설정
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
                        result.add(count);
                        count = 1;
                    }
                }
            }
            System.out.println(result.size());
        }
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nX = i + dX[k];
            int nY = j + dY[k];
            if (nX >= 0 && nY >= 0 && nX < N && nY < M && map[nX][nY] == 1 && !visited[nX][nY]) {
                count++;
                dfs(nX, nY);
            }
        }
    }
}
