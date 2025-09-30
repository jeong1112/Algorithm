import java.util.*;
class Solution {
    static int max = Integer.MIN_VALUE;
    public int solution(int[] info, int[][] edges) {

        
        int sheep = 0;
        int wolf = 0;
        
        boolean[] visited = new boolean[info.length];
        
        dfs(0, sheep, wolf, info , edges, visited);
        
        return max;
        
    }
    
    private static void dfs(int index, int sheep, int wolf, int[] info, int[][] edges, boolean[] visited){
       
        if(info[index] == 0){
            sheep++;
        }
        else{
            wolf++;
        }
        
        if(sheep <= wolf){
            return;
        }
        
        visited[index] = true;
        
        if(sheep > max){
            max = sheep;
        }   
        
        for(int[] edge : edges){
            if(visited[edge[0]] && !visited[edge[1]]){
                boolean[] newVisited = visited.clone();
                dfs(edge[1], sheep, wolf, info, edges, newVisited);
            }
        }
        
    }
}