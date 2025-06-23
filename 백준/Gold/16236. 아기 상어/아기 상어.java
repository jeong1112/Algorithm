import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dX = {0, 0, 1, -1};
    static int[] dY = {1, -1, 0, 0};
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        Node cur = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    cur = new Node(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eatCount = 0;
        int moveCount = 0;

        while (true) {
            Node nextFish = bfs(cur, size); // 다음 먹이 구하기
            if (nextFish == null) break;

            moveCount += nextFish.dist;
            cur = new Node(nextFish.x, nextFish.y, 0);
            map[cur.x][cur.y] = 0;
            eatCount++;

            if (eatCount == size) {
                size++;
                eatCount = 0;
            }
        }

        System.out.println(moveCount);
    }

    static Node bfs(Node node, int size) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];

        pq.offer(new Node(node.x, node.y, 0));
        visited[node.x][node.y] = true;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (map[cur.x][cur.y] != 0 && map[cur.x][cur.y] < size) {
                return cur;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dX[i];
                int ny = cur.y + dY[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] > size) continue;

                pq.offer(new Node(nx, ny, cur.dist + 1));
                visited[nx][ny] = true;
            }
        }

        return null;
    }

    static class Node implements Comparable<Node> {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            if (this.dist != n.dist) return this.dist - n.dist;
            if (this.x != n.x) return this.x - n.x;
            return this.y - n.y;
        }
    }
}