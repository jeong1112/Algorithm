import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) { 
            System.out.println(Integer.parseInt(br.readLine()));
            return;
        }
        int[] stairs = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        if (n == 2) { 
            System.out.println(dp[2]);
            return;
        }
        dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
        }
        System.out.println(dp[n]);
    }



}
