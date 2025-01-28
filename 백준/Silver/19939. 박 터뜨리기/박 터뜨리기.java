import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        for(int i = 0; i < k; i++){
            arr[i] += i + 1;
            n -= arr[i];
        }
        if(n < 0){
            System.out.println(-1);
            return;
        }
        if(n % k != 0){
            arr[k-1]++;
        }
        System.out.println(arr[k-1] - arr[0]);
    }

}
