// 모든 음식의 스코빌 지수가 K 이상이 되어야 함. 
// 스코빌 지수가 가장 낮은 음식 두개를 계속 섞는다.
// 우선순위 큐에서 두개 꺼내서 계속 합을 비교해야 하나?
import java.util.*;
class Solution {
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.offer(s);
        }
        
        while(pq.peek() < K){
            
            if(pq.size() < 2) return -1;
            
            answer++;
            
            int food1 = pq.poll();
            int food2 = pq.poll();
            
            int newFood = food1 + (2 * food2);
            pq.offer(newFood);
        }
        
        return answer;
    }
    
  
}