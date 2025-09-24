import java.util.*;
class Solution {
    static int[] dx = { 1,  0,  0, -1};
    static int[] dy = { 0, -1,  1,  0};
    static char[] alphabet = {'d','l','r','u'};
    static int maxDist, M, N, endX, endY;
    static String answer = null;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        endX = r - 1;
        endY = c - 1;
        M = m;
        N = n;
        maxDist = k;
    
        int dist = getDistance(x - 1, y - 1);
        if(dist > k || dist % 2 != k % 2){
            return "impossible";
        }
        
        dfs(x - 1, y - 1, new StringBuilder(""));        

        return answer;
    }
    
    private static void dfs(int x, int y, StringBuilder sb){
            
        if(answer != null) return;
        
        if(sb.length() == maxDist && x == endX && y == endY){
            answer = sb.toString();  
            return;
        } else if(sb.length() == maxDist) return;
        
        if(maxDist - sb.length() < getDistance(x,y)) return;

        
        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                sb.append(alphabet[i]);
                dfs(nx, ny, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        
    }
    
    private static int getDistance(int x, int y){
        return Math.abs(x - endX) + Math.abs(y - endY);
    }
}