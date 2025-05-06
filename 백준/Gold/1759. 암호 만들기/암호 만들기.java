import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    private static int L,C;
    private static char[] alphabets;
    private static char[] result;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabets = new char[C];
        result = new char[L];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < C ;i++){
            alphabets[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabets);
        dfs(0,0);

    }

    private static void dfs(int depth, int start){
        if(depth == L){
            if(isValidChar(result)){
                System.out.println(result);
            }
            return;
        }
        for(int i = start; i < C ; i++){
            result[depth] = alphabets[i];
            dfs(depth + 1, i+1);
        }
    }

    private static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static boolean isValidChar(char[] arr){
        int vowelCount = 0;
        int consonantCount = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(isVowel(arr[i])){
                vowelCount++;
            }
            else{
                consonantCount++;
            }
        }
        return vowelCount >= 1 && consonantCount >= 2;
    }


}
