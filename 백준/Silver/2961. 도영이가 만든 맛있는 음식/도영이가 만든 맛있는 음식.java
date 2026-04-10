import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 최소한 하나의 재료는 사용해야 하는데, 재료를 선택하던지 말던지 해서 담고, 신맛은 곱, 쓴맛은 합으로 해서 차이를 최소로 해야된다
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Ingredient> ingredients = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Ingredient ingredient = new Ingredient(s, b);
            ingredients.add(ingredient);
        }

        // 여기서 리스트 순회하면서 재료 담을지 말지 경우의수 선택해서 최솟값 갱신시켜나감.
        // 경우의 수는 2^n? 재료를 선택하거나. 선택 안하거나. n이 10보다 작으므로 ㄱㅊ.
        // 만약 재료가 5가지다. 하면? 00000이면 재료 아무것도 안 고른 것, 00001이면 다섯번재 재료만 쓴것

        int answer = Integer.MAX_VALUE;

        for(int i = 1; i < (1 << n) ; i++){

            int totalS = 1;
            int totalB = 0;

            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    totalS *= ingredients.get(j).getSour();
                    totalB += ingredients.get(j).getBitter();
                }
            }

            answer = Math.min(answer, Math.abs(totalS - totalB));
        }
        System.out.println(answer);


    }

    static class Ingredient{
        int sour;
        int bitter;

        public Ingredient(int s, int b) {
            this.sour = s;
            this.bitter = b;
        }

        public int getSour() {
            return sour;
        }

        public int getBitter() {
            return bitter;
        }
    }
}