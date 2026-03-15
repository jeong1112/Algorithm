import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        final int dividend = 1000000000;

        if (n == 1) {
            System.out.println(0);
            return;
        }

        long[] dp = new long[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            dp[i] = ((dp[i - 1] + dp[i - 2]) * (i - 1)) % dividend;
        }

        System.out.println(dp[n]);

    }

}