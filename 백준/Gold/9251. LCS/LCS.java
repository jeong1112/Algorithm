import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int lengthS1 = s1.length();
        int lengthS2 = s2.length();
        char[] c1 = new char[lengthS1 + 1];
        char[] c2 = new char[lengthS2 + 1];

        for (int i = 1; i <= lengthS1; i++) {
            c1[i] = s1.charAt(i - 1);
        }
        for (int i = 1; i <= lengthS2; i++) {
            c2[i] = s2.charAt(i - 1);
        }

        int[][] dp =  new int[lengthS1 + 1][lengthS2 + 1];

        for (int i = 1; i <= lengthS1; i++) {
            for (int j = 1; j <= lengthS2; j++) {
                if(c1[i] == c2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[lengthS1][lengthS2]);

    }


}