import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] inputA = br.readLine().split(" ");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(inputA[i]);
        }

        String[] inputB = br.readLine().split(" ");
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(inputB[i]);
        }
        
        int[] C = Arrays.copyOf(A, n);
        Arrays.sort(C);

        int[] D = Arrays.copyOf(B, n);
        Arrays.sort(D);

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += C[i] * D[n - i - 1];
        }
        System.out.println(res);
    }
}
