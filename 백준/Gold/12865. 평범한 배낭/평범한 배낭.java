import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Integer[][] dp;
    static int[] w;
    static int[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp =  new Integer[n][k+1];

        w = new int[n];
        v = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(knapsack(n-1,k));
    }

    private static int knapsack(int i, int k){
        if( i < 0){
            return 0;
        }

        if(dp[i][k] == null){
            if(w[i] > k){
                dp[i][k] = knapsack(i-1, k);
            }
            else{
                dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i -1, k - w[i]) + v[i]);
            }
        }
        return dp[i][k];
    }
}