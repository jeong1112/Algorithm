import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] prices;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n =  Integer.parseInt(st.nextToken());
        m =  Integer.parseInt(st.nextToken());
        prices = new int[n];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < n; i++){
            int priceInput = Integer.parseInt(br.readLine());
            prices[i] = priceInput;
            max = Math.max(max, priceInput);
            sum += priceInput;
        }
        int low = max;
        int high = sum;
        while(low <= high){
            int mid = (low + high) / 2;
            int withdrawCount = calculateWithdrawCount(mid);
            if(withdrawCount <= m){
                result = mid;
                high = mid - 1;
            }
            else{
                low =  mid + 1;
            }
        }
        System.out.println(result);

    }

    private static int calculateWithdrawCount(int amount) {
        int count = 1;
        int money = amount;
        for(int price : prices) {
            money -= price;
            if(money < 0) {
                count++;
                money = amount - price;
            }
        }
        return count;
    }


}