/*
    적어도 한 면이 창고 외부와 연결되어 있으면 접근이 가능하다. 
    근데 크레인을 사용하면 요청된 종류의 모든 컨테이너를 꺼낼 수 있다.
    알파벳 하나만 요청이 들어오면 접근 가능한 컨테이너만 꺼내고, 두번 들어오면 크레인
    모든 요청을 처리하고 남은 컨테이너 수를 return 해라.
    외부와 연결되어 있다는 판단을 어떻게 할 것인가?
    
    4방향을 다 탐색했을 때 모두 다 컨테이너인 경우만 아니면 외부와 연결되어 있다?
    boolean으로 컨테이너 여부를 저장하자
    
*/
import java.util.*;
class Solution {
    static int m, n;
    public int solution(String[] storage, String[] requests) {
        m = storage.length;
        n = storage[0].length();
        
        int answer = m * n;
        
        boolean[][] container = new boolean[m][n];
        
        for(String request : requests){
            
            List<int[]> picked = new ArrayList<>();
            
            if(request.length() == 1){
                for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        if(storage[i].charAt(j) == (request.charAt(0))){
                            if(isConnectedOutside(i, j, container)){
                                if(!container[i][j]){
                                    answer--;
                                    picked.add(new int[]{i, j});
                                }
                                
                            }
                        }
                        
                    }
                }
            }
            
            else{
                for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        if(storage[i].charAt(j) == (request.charAt(0))){
                            if(!container[i][j]){
                                answer--;
                                picked.add(new int[]{i, j});
                            }
                        }
                    }
                }
            }
            
            for(int[] arr : picked){
                container[arr[0]][arr[1]] = true;
            }
        }
        
        
        return answer;
    }
    
    private boolean isConnectedOutside(int x, int y, boolean[][] container){
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {

            int[] c = q.poll();
            int curX = c[0];
            int curY = c[1];

            for (int i = 0; i < 4; i++) {

                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    return true;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (container[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return false;

    }
}