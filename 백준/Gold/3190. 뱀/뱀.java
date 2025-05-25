import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};
    static int[][] matrix;
    static List<int[]> snake = new ArrayList<>();
    static int n,k,L;
    static Map<Integer, Character> map = new HashMap<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            matrix[x][y] = 1;
        }
        L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            map.put(time, direction);
        }
        snakeGame();

    }

    private static void snakeGame(){
        int time = 0;
        int curX = 0;
        int curY = 0;
        int d = 0;
        snake.add(new int[]{0,0});
        while(true){
            time++;
            int nextX = curX + dX[d];
            int nextY = curY + dY[d];

            if(isFinish(nextX,nextY)){
                break;
            }

            if(matrix[nextX][nextY] == 1){
                matrix[nextX][nextY] = 0;
                snake.add(new int[]{nextX,nextY});
            }
            else{
                snake.add(new int[]{nextX,nextY});
                snake.remove(0);
            }

            if(map.containsKey(time)){
                if(map.get(time) == 'L'){
                    d -= 1;
                    if (d == -1)
                        d = 3;
                }
                else if(map.get(time) == 'D'){
                    d += 1;
                    if(d == 4){
                        d = 0;
                    }
                }
            }

            curX = nextX;
            curY = nextY;

        }
        System.out.println(time);
    }

    private static boolean isFinish(int nextX, int nextY) {
        if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n){
            return true;
        }

        for (int[] ints : snake) {
            if(ints[0] == nextX && ints[1] == nextY){
                return true;
            }
        }
        return false;
    }

}
