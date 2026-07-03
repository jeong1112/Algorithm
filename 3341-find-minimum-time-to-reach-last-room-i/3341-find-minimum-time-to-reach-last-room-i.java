import java.util.*;
class Solution {

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int time;

        public Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Node n){
            return Integer.compare(this.time, n.time);
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        // 번호랑 moveTime을 담아두고 Node를 저장하자.
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        int[][] time = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                time[i][j] = Integer.MAX_VALUE;
            }
        }
        time[0][0] = 0;

        boolean[][] visited = new boolean[n][m];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int curX = now.x;
            int curY = now.y;

            if(visited[curX][curY]) continue;
            visited[curX][curY] = true;


            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;

                int nextTime = Math.max(now.time, moveTime[nextX][nextY]) + 1;
                if(nextTime < time[nextX][nextY]){
                    time[nextX][nextY] = nextTime;
                    pq.offer(new Node(nextX, nextY, nextTime));
                }
            }
        }

        return time[n - 1][m - 1];

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna