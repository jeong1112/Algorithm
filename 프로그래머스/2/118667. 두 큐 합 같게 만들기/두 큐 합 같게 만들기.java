import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long q1Sum = getArrSum(queue1);
        long q2Sum = getArrSum(queue2);
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        while(true){
            
            if(q1Sum == q2Sum) break;
            //합을 같게 만들 수 없는 경우 ?
            if(answer > (queue1.length + queue2.length) * 2) return -1;
            
            //합이 더 큰쪽에서 pop을 한다
            if(q1Sum > q2Sum){
                int tmp = q1.poll();
                q2.add(tmp);
                q1Sum -= (long)tmp;
                q2Sum += (long)tmp;
            }
            else{
                int tmp = q2.poll();
                q1.add(tmp);
                q1Sum += (long)tmp;
                q2Sum -= (long)tmp;
            }
            answer++;
        }
        
               
        return answer;
        
    }
    
    private static int getArrSum(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        return sum;
    }
}