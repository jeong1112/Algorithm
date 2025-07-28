import java.util.*;
class Solution {
    static Queue<int[]>[] q;
    static int answer;
    static int size;
    public int solution(int[][] points, int[][] routes) {
        size = routes.length; // 로봇의 수
        q = new LinkedList[size];
        for(int i = 0 ; i < size; i++){
            q[i] = new LinkedList<>();
        }

        calculateRoute(points, routes);
        
        calculateConflict();

        return answer;
    }
    private static void calculateRoute(int[][] points, int[][] routes){
        for(int i = 0; i < size; i++){
            int[] point = points[routes[i][0]- 1];
            int x = point[0];
            int y = point[1];
            q[i].add(new int[]{x,y});
            for(int j = 1; j < routes[0].length; j++){
                int[] nextPoint = points[routes[i][j] - 1];
                int nx = nextPoint[0];
                int ny = nextPoint[1];
                
                int xp = nx - x; 
                int yp = ny - y;
                while(xp != 0){
                    if(xp > 0){
                        xp--;
                        x++;
                        q[i].add(new int[]{x, y});
                    }
                    else{
                        xp++;
                        x--;
                        q[i].add(new int[]{x, y});
                    }
                }
                while(yp != 0){
                    if(yp > 0){
                        yp--;
                        y++;
                        q[i].add(new int[]{x, y});
                    }
                    else{
                        yp++;
                        y--;
                        q[i].add(new int[]{x, y});
                    }
                }
            }
        }
    }
    
    private static void calculateConflict(){
        int count = 0;
        while(count != size){
            int [][] map = new int [101][101];
            count = 0;
            for(int i = 0; i < size; i++){
                if(q[i].isEmpty()){
                    count++;
                    continue;
                }
                int [] temp = q[i].poll();
                map[temp[0]][temp[1]]++;
            }
            for(int i = 0; i < 101; i++){
                for(int j = 0; j < 101; j++){
                    if(map[i][j] > 1) answer++;
                }
            }
        }
    }
}