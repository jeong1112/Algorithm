import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static int k;
    private static int[] lotto;
    private static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0){
                break;
            }
            arr = new int[k];
            visited = new boolean[k];
            lotto = new int[6];
            for(int i = 0 ; i < k ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            System.out.println();
        }

    }

    private static void dfs(int depth, int start){
        if(depth == 6){
            for (int i : lotto) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start ; i < k ; i++){
            if(!visited[i]){
                visited[i] = true;
                lotto[depth] = arr[i];
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }

    }



}
