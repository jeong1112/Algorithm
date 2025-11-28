import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());
        int[] colors = new int[m];

        int high = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            colors[i] = Integer.parseInt(br.readLine());
            high =  Math.max(colors[i], high);
        }

        int low = 1;
        int answer = 0;

        while(low <= high){
            int mid = (low + high) / 2;
            int sum = 0;

            for(int i = 0 ; i < m ; i++){
                if(colors[i] % mid == 0){
                    sum += colors[i] / mid;
                }
                else{
                    sum += colors[i] / mid + 1;
                }
            }

            if(sum > n){
                low = mid + 1;
            }
            else{
                high = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);



    }

}