import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] edgeCount = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edgeCount[to]++;
            graph.get(from).add(to);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++){
            if(edgeCount[i] == 0){
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int node = q.poll();
            sb.append(node).append(" ");

            List<Integer> list = graph.get(node);
            for (int neighbor : list) {
                edgeCount[neighbor]--;
                if(edgeCount[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }
        System.out.print(sb);

    }

}