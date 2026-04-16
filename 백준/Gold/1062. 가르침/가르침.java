import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 이미 5개의 글자를 무조건 배운다. a n t i c, k가 5보다 작으면 0임
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = 0;

        if(k < 5){
            System.out.println(0);
            return;
        }

        Set<Character> fixed = Set.of('a', 'n', 't', 'i', 'c');
        Map<Character, Integer> extra = new HashMap<>();

        int idx = 0;
        for(char c = 'a'; c <= 'z'; c++){
            if(!fixed.contains(c)){
                extra.put(c, idx);
                idx++;
            }
        }

        int[] wordMask = new int[n];
        for(int i = 0; i < n ; i++){
            String newWord = br.readLine();
            for(char c : newWord.toCharArray()){
                if(!fixed.contains(c)){
                    wordMask[i] |= (1 << extra.get(c));
                }
            }
        }

        for(int i = 0; i < (1 << 21); i++){
            if(Integer.bitCount(i) != (k - 5)) continue;

            int count = 0;
            for(int wordBit : wordMask){
                if((i & wordBit) == wordBit){
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);

    }

}