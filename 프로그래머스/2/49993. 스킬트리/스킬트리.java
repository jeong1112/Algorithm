import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
    
        
        for(String s : skill_trees){
            int idx = 0;
            boolean success = true;
            
            for(int i = 0; i < s.length(); i++){
                char now = s.charAt(i);
                int pos = skill.indexOf(now);
                if(pos == -1) continue;
                
                if(pos != idx){
                    success = false;
                    break;
                }
                idx++;
            }
            
            if(success){
                answer++;
            }
        

        }
        
        return answer;
    }
}