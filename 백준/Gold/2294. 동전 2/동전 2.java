import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] v = new int[n];
        int[] dp = new int[k+1];

        Arrays.sort(v);
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        for(int i = 0; i < n; i++){
            v[i] =  Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        for(int i = 0; i < n; i++){
            for(int j = v[i]; j <= k; j++){
                dp[j] = Math.min(dp[j], dp[j-v[i]] + 1) ;
            }
        }
        int result = dp[k] == Integer.MAX_VALUE -1 ? -1 : dp[k];
        System.out.println(result);
    }

}