import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static int[] sequence;
    private static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sequence = new int[m];
        visited = new boolean[n];
        dfs(0,0);

    }

    private static void dfs(int depth, int start){
        if(depth == m){
            for (int i : sequence) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                sequence[depth] = i + 1;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }

        }
    }



}
