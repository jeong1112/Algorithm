import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int a = 0;
        int num = 666;
        while(true) {
            if(a == n) {
                num--;
                System.out.println(num);
                break;
            }
            String s = Integer.toString(num);
            if(s.contains("666")){
                a++;
            }
            num++;
        }
    }
}
