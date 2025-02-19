import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0 || n == 1) {
                System.out.println(1);
                continue;
            }
            else if(n == 2) {
                System.out.println(2);
                continue;
            }

            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 1;
            dp[2] = 2;
            for(int j = 3; j <= n ; j++){
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            System.out.println(dp[n]);
        }

    }


}
