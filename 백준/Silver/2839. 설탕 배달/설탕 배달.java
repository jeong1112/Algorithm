import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = 0;
        while(n > 0){
           if (n % 5 == 0){
               min += n / 5;
               System.out.println(min);
               return;
           }
           if (n < 3){
               System.out.println(-1);
               return;
           }
           n -= 3;
           min++;
        }
        System.out.println(min);
    }


}
