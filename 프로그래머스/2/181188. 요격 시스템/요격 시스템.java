import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int answer = 0;
        int end = -1;
        
        for(int[] t : targets){
            int s = t[0];
            int e = t[1];
            
            if(s >= end){
                answer++;
                end = e;
            }
        }
        
        return answer;
    }
}