import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        int count = 1;

        while (b > a) {
            if (b % 10 == 1) {
                b /= 10;
                count++;
            } else if (b % 2 == 0) {
                b /= 2;
                count++;
            } else {
                break;
            }
        }

        System.out.println(b == a ? count : -1);
    }
}
