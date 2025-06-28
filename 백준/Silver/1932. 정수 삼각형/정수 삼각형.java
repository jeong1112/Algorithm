import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n =  Integer.parseInt(br.readLine());
        int[][] triangle = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < i + 1; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) +  triangle[i][j];
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            if(answer < dp[n][i]){
                answer = dp[n][i];
            }
        }
        System.out.println(answer);



    }


}