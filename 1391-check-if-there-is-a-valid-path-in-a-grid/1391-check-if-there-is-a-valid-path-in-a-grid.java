class Solution {
    static int[] dx, dy;
    static int[][] dirs;
    static int m, n;
    static int[][] grid;

    public boolean hasValidPath(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        this.grid = grid;

        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0 ,-1};
        // 0 : 위, 1 : 오른, 2 : 아래, 3 : 왼
        
        // Street 1 ~ Street 6
        dirs = new int[][]{
            {},
            {3, 1}, 
            {0, 2},
            {3, 2},
            {1, 2},
            {3, 0},
            {1, 0}
        };

        return bfs();

    }

    private boolean bfs(){
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});

        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if(x == m - 1 && y == n - 1){
                return true;
            }

            // 현재 탐색 중인 도로가 몇 번인지..
            int now = grid[x][y];

            for(int dir : dirs[now]){
                // dirs[now]는 {3, 1} 이런식임
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                if(visited[nx][ny]) continue;

                // 현재 진행 방향의 반대 방향이 열려있어야 도로를 건너갈 수 있다.
                int next = grid[nx][ny];
                int oppositeDir = (dir + 2) % 4;
                if(canConnect(dirs[next], oppositeDir)){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }

            }

        }
        return false;
    }

    private boolean canConnect(int[] dirs, int target){
        for(int dir : dirs){
            if(dir == target){
                return true;
            }
        }
        return false;
    }
    
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna