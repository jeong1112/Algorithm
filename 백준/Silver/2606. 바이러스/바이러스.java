import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List[] computers ;
    static int count = 0;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        computers = new List[n + 1];
        visited = new boolean[n + 1];
        for(int i = 1; i < n + 1; i++) {
            computers[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers[a].add(b);
            computers[b].add(a);
        }
        bfs(1);
        System.out.println(count - 1);


    }

    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(!visited[cur]) {
                visited[cur] = true;
                count++;
                for(int j = 0; j < computers[cur].size(); j++) {
                    q.add((int)computers[cur].get(j));
                }
            }

        }
    }



}
