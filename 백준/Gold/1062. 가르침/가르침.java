import java.io.*;
import java.util.*;

public class Main {
    static int k, n, remain;
    static int[] wordMasks;
    static int answer = 0;
    static final int FIXED; // a, n, t, i, c 고정 비트

    static {
        int mask = 0;
        for (char c : new char[]{'a','n','t','i','c'}) {
            mask |= (1 << (c - 'a'));
        }
        FIXED = mask;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (k < 5) { System.out.println(0); return; }

        wordMasks = new int[n];
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (char c : word.toCharArray()) {
                wordMasks[i] |= (1 << (c - 'a'));
            }
        }

        remain = k - 5;
        if (remain >= 21) { System.out.println(n); return; }

        dfs(0, FIXED, 0);
        System.out.println(answer);
    }

    static void dfs(int start, int chosen, int count) {
        if (count == remain) {
            int wordCnt = 0;
            for (int wm : wordMasks) {
                if ((chosen & wm) == wm) wordCnt++;
            }
            answer = Math.max(answer, wordCnt);
            return;
        }

        if (26 - start < remain - count) return; // 가지치기

        for (int i = start; i < 26; i++) {
            if ((FIXED & (1 << i)) != 0) continue; // fixed 글자 skip
            dfs(i + 1, chosen | (1 << i), count + 1);
        }
    }
}