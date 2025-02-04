import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args)throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      List<Integer> plus = new ArrayList<>();
      List<Integer> minus = new ArrayList<>();
      int n = Integer.parseInt(br.readLine());
      for(int i = 0; i < n; i++) {
          int temp = Integer.parseInt(br.readLine());
          if(temp > 0) {
              plus.add(temp);
          }
          else{
              minus.add(temp);
          }
      }
      Collections.sort(plus,Collections.reverseOrder());
      Collections.sort(minus);

      int sum = 0;
      int i = 0;

      while(i < plus.size()) {
          if(i+1 < plus.size() && plus.get(i) != 1 && plus.get(i+1) != 1) {
              sum += plus.get(i++) * plus.get(i++);
          }
          else{
              sum += plus.get(i++);
          }
      }
      int j = 0;
      while(j < minus.size()) {
          if(j+1 < minus.size() && minus.get(j) != 1 && minus.get(j+1) != 1) {
              sum += minus.get(j++) * minus.get(j++);
          }
          else{
              sum += minus.get(j++);
          }
      }
        System.out.println(sum);


    }
}
