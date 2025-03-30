import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
N-Queen 문제의 규칙
같은 행에 2개 이상의 퀸이 있을 수 없습니다.
같은 열에 2개 이상의 퀸이 있을 수 없습니다.
방향의 대각선과 / 방향의 대각선 모두에 2개 이상의 퀸이 있을 수 없습니다.
 */
public class Main {
    private static int n;
    private static int[][] board;
    private static int count = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int depth){
        if(depth == n){
            count++;
            return;
        }
        for(int i = 0; i < n; i++){
           if(isSafe(depth,i)){
               board[depth][i] = 1;
               dfs(depth + 1);
               board[depth][i] = 0;
           }
        }

    }
    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }



}
