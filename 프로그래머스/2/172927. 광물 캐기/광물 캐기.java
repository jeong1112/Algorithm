import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int sum = picks[0] + picks[1] + picks[2];
        int totalMineral = Math.min(sum * 5, minerals.length);
        
        List<int[]> group = new ArrayList<>();
        
        for(int i = 0; i < totalMineral; i += 5){
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            
            for(int j = i; j < i + 5; j++){
                if(j == totalMineral) break;
                
                if(minerals[j].equals("diamond")){
                    diamond++;
                }
                else if(minerals[j].equals("iron")){
                    iron++;
                }
                else{
                    stone++;
                }
                
            }  
            group.add(new int[]{diamond, iron, stone});     
        }
        
        group.sort((a, b) -> {
            int scoreA = a[0] * 25 + a[1] * 5 + a[2];
            int scoreB = b[0] * 25 + b[1] * 5 + b[2];
            return scoreB - scoreA;
        });
        // 돌 곡괭이로 처리할 때 가장 힘든 순으로 내림차순 정렬함. 
        // 이제 이 순서대로 다이아를 다 소모하고, 철을 소모하고, 돌을 소모한다.
        for(int[] g : group){
            if(picks[0] > 0){
                answer += g[0] + g[1] + g[2];
                picks[0]--;
                continue;
            }
            if(picks[1] > 0){
                answer += g[0] * 5 + g[1] + g[2];
                picks[1]--;
                continue;
            }
            if(picks[2] > 0){
                answer += g[0] * 25 + g[1] * 5 + g[2];
                picks[2]--;
                continue;
            }
        }
        
        return answer;
    }
}