import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] sequence;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st =  new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sequence = new int[n];
        visited = new boolean[n];
        answer = new int[n];
        st =  new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sequence);
        dfs(0);
        System.out.println(sb.toString());

    }
    static void dfs(int depth){
        if(depth == m){
            for(int i = 0; i < m; i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = sequence[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }

    }




}