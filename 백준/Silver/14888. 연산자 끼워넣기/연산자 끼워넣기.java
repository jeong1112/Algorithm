import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] sequence;
    private static int[] operator;
    private static int n;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sequence = new int[n];
        operator = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(sequence[0],1 );
        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int num, int depth){
        if(depth == n){
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        for(int i = 0 ; i < 4; i++){
            if(operator[i] > 0){
                operator[i]--;
                switch(i){
                    case 0:
                        dfs(num + sequence[depth], depth+1);
                        break;
                    case 1:
                        dfs(num - sequence[depth], depth+1);
                        break;
                    case 2:
                        dfs(num * sequence[depth], depth+1);
                        break;
                    case 3:
                        dfs(num / sequence[depth], depth+1);
                        break;
                }
                operator[i]++;
            }
        }

    }
}
