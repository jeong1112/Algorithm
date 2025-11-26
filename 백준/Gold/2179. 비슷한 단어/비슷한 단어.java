import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }

        int max = Integer.MIN_VALUE;
        int sIndex = -1;
        int tIndex = -1;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i].equals(arr[j])) continue;
                int similarity = calculateSimilarity(arr[i], arr[j]);
                if(similarity > max){
                    max = similarity;
                    sIndex = i;
                    tIndex = j;

                }
            }
        }
        System.out.println(arr[sIndex]);
        System.out.println(arr[tIndex]);

    }

    private static int calculateSimilarity(String s1, String s2){
        int length1 = s1.length();
        int length2 = s2.length();
        int length = Math.min(length1, length2);
        int count = 0;
        for(int i = 0; i < length; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                break;
            }
            count++;
        }
        return count;
    }


}