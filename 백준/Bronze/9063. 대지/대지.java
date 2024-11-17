import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] X = new int[n];
        int[] Y = new int[n];
        if(n <= 1){
            System.out.println(0);
            return;
        }
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(X);
        Arrays.sort(Y);
        int resultX = X[X.length - 1] - X[0];
        int resultY = Y[Y.length - 1] - Y[0];
        System.out.println(resultX * resultY);
    }
}


