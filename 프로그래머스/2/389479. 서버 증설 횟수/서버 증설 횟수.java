
class Solution {
    public int solution(int[] players, int m, int k) {
        
        int totalCount = 0;
        
        int[] server = new int[24]; 
        
        for(int i = 0; i < 24; i++){
           
            int requiredServer = players[i] / m;
            

            int increaseCount = requiredServer - server[i];
            
            if(increaseCount < 0) continue;
            
            totalCount += increaseCount;
            
            if(increaseCount > 0){
                for(int j = i; j < i + k; j++){
                    if(j >= 24) continue;
                    server[j] += increaseCount;
                }
            }
        }
        
        return totalCount;
    }
}