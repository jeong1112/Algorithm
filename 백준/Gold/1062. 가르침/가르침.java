import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k;
    static String[] words;
    static int answer = 0;
    static boolean[] used;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if(k < 5){
            System.out.println(0);
            return;
        }

        words = new String[n];

        for(int i = 0; i < n; i++){
            words[i] = br.readLine();
        }

        used = new boolean[26];
        used['a' - 'a'] = true;
        used['n' - 'a'] = true;
        used['t' - 'a'] = true;
        used['i' - 'a'] = true;
        used['c' - 'a'] = true;

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int count){
        if(count == (k - 5)){
            countWord();
        }

        for(int i = idx; i < 26; i++){
            if(used[i]) continue;

            used[i] = true;
            dfs(i + 1, count + 1);
            used[i] = false;
        }
    }

    private static void countWord() {
        int wordCnt = 0;
        for(String word : words){
            char[] charArr = word.toCharArray();
            boolean flag = true;
            for(char c : charArr){
                if(!used[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                wordCnt++;
            }
        }
        answer = Math.max(answer, wordCnt);
    }


}