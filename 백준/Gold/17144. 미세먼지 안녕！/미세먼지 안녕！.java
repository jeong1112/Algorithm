import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R,C,T;
    static int[][] map;
    static int air1, air2;
    static int[] dX = {0,0,1,-1};
    static int[] dY = {1,-1,0,0};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for(int i = 0; i < R ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < R; i++){
            if(map[i][0] == -1){
                air1 = i;
                air2 = i+1;
                break;
            }
        }

        for(int i = 0; i < T; i++){
            solve();
        }
        System.out.println(count() + 2);
    }

    //먼지가 퍼지고, 공기청정기로 먼지가 죽는 것을 구현해야 함.
    private static void solve(){
        map = spreadDust();
        simulation();
    }

    private static void simulation(){
        int top = air1;

        for (int x = top - 1; x > 0; x--) {
            map[x][0] = map[x - 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[0][y] = map[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            map[x][C - 1] = map[x + 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[top][y] = map[top][y - 1];
        }

        map[top][1] = 0;

        int bottom = air2;

        for (int x = bottom + 1; x < R - 1; x++) {
            map[x][0] = map[x + 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[R - 1][y] = map[R - 1][y + 1];
        }

        for (int x = R - 1; x > bottom; x--) {
            map[x][C - 1] = map[x - 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[bottom][y] = map[bottom][y - 1];
        }

        map[bottom][1] = 0;
    }


    private static int[][] spreadDust() {
        int[][] tempMap = new int[50][50];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    tempMap[i][j] = -1;
                    continue;
                }
                tempMap[i][j] += map[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = j + dX[k];
                    int ny = i + dY[k];

                    if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                    if (map[ny][nx] == -1) continue;

                    tempMap[ny][nx] += (map[i][j] / 5);
                    tempMap[i][j] -= (map[i][j] / 5);
                }
            }
        }
        return tempMap;
    }
    public static int count() {
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                cnt += map[i][j];
            }
        }
        return cnt;
    }

}
