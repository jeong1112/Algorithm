import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[101][101];
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int row = 3;
        int col = 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        while(true){
            if(arr[r-1][c-1] == k){
                break;
            }
            if(time > 100) break;

            if(row >= col){
                // 이러면 R 연산, 모든 행에 대해서 정렬 수행
                for(int i = 0; i < row; i++){
                    for(int j = 0; j < col; j++){
                        if(arr[i][j] != 0){
                            map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                        }
                    }
                    Arrays.fill(arr[i], 0);
                    if(map.isEmpty()){
                        continue;
                    }
                    for (Integer num : map.keySet()) {
                        list.add(new Node(num, map.get(num)));
                    }
                    Collections.sort(list);
                    col = Math.max(col, list.size() * 2);
                    int index = 0;
                    for (Node node : list) {
                        arr[i][index++] = node.num;
                        arr[i][index++] = node.count;
                    }
                    map.clear();
                    list.clear();
                }

            }
            else{
                // C 연산, 모든 열에 대해서 정렬 수행
                for(int i = 0; i < col; i++){
                    for(int j = 0; j < row; j++){
                        if(arr[j][i] != 0){
                            map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
                        }
                    }
                    for (int j = 0; j < 101; j++) arr[j][i] = 0;
                    if(map.isEmpty()){
                        continue;
                    }
                    for (Integer num : map.keySet()) {
                        list.add(new Node(num, map.get(num)));
                    }
                    Collections.sort(list);
                    row = Math.max(row, list.size() * 2);
                    int index = 0;
                    for (Node node : list) {
                        arr[index++][i] = node.num;
                        arr[index++][i] = node.count;
                    }
                    map.clear();
                    list.clear();
                }

            }
            time++;

        }

        System.out.println(time > 100 ? -1 : time);



    }

    private static class Node implements Comparable<Node>{
        int num;
        int count;

        @Override
        public int compareTo(Node o) {
            if(this.count == o.count) return this.num - o.num;
            return this.count - o.count;
        }

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }



}