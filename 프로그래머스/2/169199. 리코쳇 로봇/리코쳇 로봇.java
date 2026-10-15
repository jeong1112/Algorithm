import java.util.*;
class Solution {
    
    static int startX, startY;
    static int targetX, targetY;
    
    static class Position{
        int x;
        int y;
        int distance;
        
        public Position(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    public int solution(String[] board) {
        int[] dx = {-1, 0 ,1, 0};
        int[] dy = {0, 1, 0, -1};
        
        int answer = 0;
        Queue<Position> q = new LinkedList<>();
        
        int m = board.length;
        int n = board[0].length();
        
        boolean[][] visited = new boolean[m][n];
        
        findPosition(board, 'R');
        findPosition(board, 'G');
        
        q.offer(new Position(startX, startY, 0));
        visited[startX][startY] = true;
        
        // bfs 탐색하는데 큐에 넣을 때 한쪽 방향으로 끝까지 보낸 다음에 넣는다.
        while(!q.isEmpty()){
            Position p = q.poll();
            
            int currX = p.x;
            int currY = p.y;
            
            if(currX == targetX && currY == targetY){
                return p.distance;
            }
            
            // 네 방향으로 쭉 보내고 큐에 넣는다.
            for(int i = 0; i < 4; i++){
                int nextX = currX;
                int nextY = currY;
                
                while(true){
                    int nx = nextX + dx[i];
                    int ny = nextY + dy[i];

                    if(nx < 0 || nx >= m || ny < 0 || ny >= n) break;
                    if(board[nx].charAt(ny) == 'D') break;

                    nextX = nx;
                    nextY = ny;
                }   
                
                if(visited[nextX][nextY]) continue;
                
                q.offer(new Position(nextX, nextY, p.distance + 1));
                visited[nextX][nextY] = true;
            }
        }
        
        return -1;
    }
    
    public void findPosition(String[] board, char c){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                if(board[i].charAt(j) == c){
                    if(c == 'R'){
                        this.startX = i;
                        this.startY = j;
                        break;
                    }
                    if(c == 'G'){
                        this.targetX = i;
                        this.targetY = j;
                        break;
                    }
                }
            }
        }
    }
}