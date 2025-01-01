import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while(n >= 5){
            count += (n /= 5);
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}
