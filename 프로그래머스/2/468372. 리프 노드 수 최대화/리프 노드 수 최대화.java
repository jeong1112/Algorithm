class Solution {
    int answer = 1;
    public int solution(int dist_limit, int split_limit) {
        
        dfs(1, 1, 0, 1, dist_limit, split_limit);
        return answer;
    }
    
    private void dfs(long currentDist, long usedDist, long leaf, long split, long dist_limit, long split_limit){
        if(currentDist < 0) return;
        
        answer = (int)Math.max(answer, leaf + currentDist);
        
        for(int i = 2; i <= 3; i++){
            
            if(split * i > split_limit) continue;
            
            // 다음에 분배 노드로 사용할 리프 노드 수 결정
            long nextDist = Math.min(dist_limit - usedDist, i * currentDist);
            
            dfs(nextDist, usedDist + nextDist, leaf + (i * currentDist - nextDist), split * i, dist_limit, split_limit);
            
        }
    }
    
}