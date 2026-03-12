// 두 문자열 중 하나에서 한 문자를 삭제하는 것이 1회의 작업이다.
// LCS를 구해야함
import java.util.*;
class Solution {
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= m; j++){

                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j -1], dp[i - 1][j]);
                }
            }
        }

        return n + m - (dp[n][m] * 2);

    }
}