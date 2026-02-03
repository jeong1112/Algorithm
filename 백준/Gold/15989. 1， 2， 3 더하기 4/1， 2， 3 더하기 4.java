import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =  Integer.parseInt(br.readLine());
        int[][] dp = new int[10001][4];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4; i < 10001; i++){
            dp[i][1] = 1;
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] +  dp[i-3][3];
        }


        for(int i = 0; i < T; i++){
            int n =  Integer.parseInt(br.readLine());
            int sum = 0;
            for(int j = 1; j <= 3; j++){
                sum += dp[n][j];
            }
            System.out.println(sum);

        }


    }


}