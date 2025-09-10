import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] conveyer;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       st = new StringTokenizer(br.readLine());

       int n =  Integer.parseInt(st.nextToken());
       k =  Integer.parseInt(st.nextToken());

       conveyer = new int[2 * n];
       robot = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
           conveyer[i] = Integer.parseInt(st.nextToken());
       }
       int step = 0;
       while(true){
           step++;
           //컨베이어 벨트 한 칸씩 옮기기
           int temp = conveyer[2*n-1];
           for(int i = 2*n-1 ; i > 0 ; i--){
               conveyer[i] = conveyer[i-1];
           }
           conveyer[0] = temp;

           //로봇 옮기기
           for(int i = n - 1; i > 0; i--){
               robot[i] = robot[i-1];
           }

           robot[0] = false;
           robot[n - 1] = false;

           //로봇 이동시키기
           for(int i = n - 1; i > 0; i--){
               if(robot[i-1] && !robot[i] && conveyer[i] > 0){
                   robot[i-1] = false;
                   robot[i] = true;
                   conveyer[i]--;
                   robot[n-1] = false;
               }
           }

           //로봇 올리기
           if(conveyer[0] > 0){
               robot[0] = true;
               conveyer[0]--;
           }

           if(isFinished()) break;
       }
        System.out.println(step);

    }

    private static boolean isFinished(){
        int count = 0;
        for (int i : conveyer) {
            if(i == 0) count++;
        }
        return count >= k;
    }

}