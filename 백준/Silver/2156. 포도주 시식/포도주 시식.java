import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static Integer[] dp;
    static int[] wine;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =  Integer.parseInt(br.readLine());
        wine =  new int[n+1];
        for(int i = 1; i < n+1; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp = new Integer[n+1];

        dp[0] = 0;
        dp[1] = wine[1];
        if(n > 1){
            dp[2] = wine[1] + wine[2];
        }
        System.out.println(recur(n));

    }

    private static int recur(int i){
        if (dp[i] == null) {
            dp[i] = Math.max(
                    recur(i - 1),
                    Math.max(recur(i - 2) + wine[i], recur(i - 3) + wine[i - 1] + wine[i])
            );
        }
        return dp[i];
    }


}