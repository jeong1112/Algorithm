import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] maxDP = new String[101];
        String[] minDP = new String[101];

        // 최댓값
        maxDP[2] = "1";
        maxDP[3] = "7";
        for(int i = 4; i < 101; i++){
            if(i % 2 == 0){
                maxDP[i] = maxDP[i-2] + "1";
            }
            else{
                maxDP[i] = "7" + maxDP[i-3];
            }
        }

        // 최솟값
        Arrays.fill(minDP, String.valueOf(Long.MAX_VALUE));
        minDP[2] = "1";
        minDP[3] = "7";
        minDP[4] = "4";
        minDP[5] = "2";
        minDP[6] = "6";
        minDP[7] = "8";
        minDP[8] = "10";
        String[] digit = {"1", "7", "4", "2", "0", "8"};

        for (int i = 9; i <= 100; i++) {
            String best = null;
            for (int j = 2; j <= 7; j++) {
                if (minDP[i - j] == null) continue;
                String cand = minDP[i - j] + digit[j - 2];
                if (isSmaller(cand, best)) best = cand;
            }
            minDP[i] = best;
        }

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(minDP[n] + " " + maxDP[n]);
        }

    }

    private static boolean isSmaller(String a, String b) {
        if (b == null) return true;
        if (a.length() != b.length()) return a.length() < b.length();
        return a.compareTo(b) < 0;
    }


}