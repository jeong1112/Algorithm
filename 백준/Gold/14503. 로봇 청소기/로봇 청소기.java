import java.io.*;
import java.util.*;

public class Main {
    static int[][] room;
    static int count = 0;
    static int n, m;

    // 북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        room = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(x, y, direction);
        System.out.println(count);
    }

    private static void clean(int x, int y, int direction) {
        if (room[x][y] == 0) {
            room[x][y] = 2;
            count++;
        }

        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (isInBounds(nx, ny) && room[nx][ny] == 0) {
                clean(nx, ny, direction);
                return;
            }
        }

        int back = (direction + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if (isInBounds(bx, by) && room[bx][by] != 1) {
            clean(bx, by, direction);
        }
    }

    private static boolean isInBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}