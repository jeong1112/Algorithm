import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 30;
    static int[][] dp = new int[MAX][MAX];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        combie();
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(dp[M][N]);



        }


    }
    private static void combie(){
        for(int i = 1; i < MAX; i++) {
            dp[i][1] = i;
        }

        for(int i = 2; i < MAX; i++) {
            for(int j = 2; j < MAX; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
    }

}
