import java.util.*;
class Solution {
    static final int MAX = 120;
    public int solution(int[][] info, int n, int m) {
        int answer = MAX;
        int size = info.length;
        
        int[][] dp = new int[size + 1][m];
        for(int i = 0 ; i <= size; i++){
            Arrays.fill(dp[i], MAX);
        }
        dp[0][0] = 0;
        
        for(int i = 1; i <= size; i++){
            int a = info[i - 1][0]; // A가 남기는 흔적의 개수
            int b = info[i - 1][1]; // B가 남기는 흔적의 개수
            
            for(int j = 0; j < m ; j++){
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                if(j + b < m){
                    dp[i][j + b] = Math.min(dp[i][j+b], dp[i-1][j]);
                }
            }
        }
        for(int i = 0; i < m; i++){
            answer = Math.min(answer, dp[size][i]);
        }
        
        return answer >= n ? -1 : answer;
    }
}