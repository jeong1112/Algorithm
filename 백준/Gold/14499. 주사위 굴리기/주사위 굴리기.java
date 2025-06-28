import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,x,y,k;
    static int[] command;
    static int[][] map;
    static int[] dice; // 윗 면이 1, 아랫 면이 6이니까, 인덱스 0번이 윗면, 5번이 아랫면으로 설정
    static final int EAST = 1;
    static final int WEST = 2;
    static final int NORTH = 3;
    static final int SOUTH = 4;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        command = new int[k];
        map = new int[n][m];
        dice = new int[6];
        for(int i = 0; i < n; i++){
            st =  new StringTokenizer(br.readLine());
            for(int  j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            command[i] = Integer.parseInt(st.nextToken());
        }
        rollDice(x,y);
    }

    private static void rollDice(int x, int y){
        int curX = x;
        int curY = y;
        int nextX, nextY;
        for (int i = 0; i < k; i++) {
            nextX = curX;
            nextY = curY;

            int[] newDice = dice.clone();

            switch (command[i]) {
                case EAST:
                    nextY++;
                    if (nextY >= m) continue;
                    newDice[0] = dice[3]; 
                    newDice[2] = dice[0];
                    newDice[5] = dice[2]; 
                    newDice[3] = dice[5];
                    break;
                case WEST:
                    nextY--;
                    if (nextY < 0) continue;
                    newDice[0] = dice[2];
                    newDice[3] = dice[0];
                    newDice[5] = dice[3];
                    newDice[2] = dice[5];
                    break;
                case NORTH:
                    nextX--;
                    if (nextX < 0) continue;
                    newDice[0] = dice[1];
                    newDice[1] = dice[5];
                    newDice[5] = dice[4];
                    newDice[4] = dice[0];
                    break;
                case SOUTH:
                    nextX++;
                    if (nextX >= n) continue;
                    newDice[0] = dice[4];
                    newDice[4] = dice[5];
                    newDice[5] = dice[1];
                    newDice[1] = dice[0];
                    break;
            }

            dice = newDice;

            if (map[nextX][nextY] == 0) {
                map[nextX][nextY] = dice[5];
            } else {
                dice[5] = map[nextX][nextY];
                map[nextX][nextY] = 0;
            }

            System.out.println(dice[0]);

            curX = nextX;
            curY = nextY;
        }
    }

}