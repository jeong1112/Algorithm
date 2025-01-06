import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nums = br.readLine().split("-");
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            String[] addNums = nums[i].split("\\+");
            int temp = 0;

            for(int j = 0; j < addNums.length; j++) {
                temp += Integer.parseInt(addNums[j]);
            }
            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }
            else{
                sum -= temp;
            }
        }
        System.out.println(sum);

    }


}
