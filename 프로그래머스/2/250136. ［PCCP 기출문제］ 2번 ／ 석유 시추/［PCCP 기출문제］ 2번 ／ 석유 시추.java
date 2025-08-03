import java.util.*;
class Solution {
    static int n,m,answer;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] oil;
    public int solution(int[][] land) {
        answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        oil = new int[m];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    bfs(i, j, land);
                }
            }
        }
        answer = Arrays.stream(oil).max().getAsInt();
        return answer;
    }
    
    private static void bfs(int i, int j, int[][] land){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        
        int count = 1;
        
        Set<Integer> colSet = new HashSet<>();
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            colSet.add(now[1]);
            
            for(int k = 0 ; k < 4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(land[nx][ny] == 1 && !visited[nx][ny]){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        for(int index : colSet){
            oil[index] += count;
        }
        
        
    }
    
}