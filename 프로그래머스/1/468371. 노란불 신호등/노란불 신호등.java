import java.util.*;
class Solution {
    public int solution(int[][] signals) {
  
        
        // 주기의 최소공배수 내에 답이 있다
        int totalLcm = 1;
  
        // 각 신호등 주기 저장
        int[] period = new int[signals.length];
        for(int i = 0; i < signals.length; i++){
            period[i] = signals[i][0] + signals[i][1] + signals[i][2];
            totalLcm = lcm(totalLcm, period[i]);
        }
        
        // 주기 % 특정 시각 하면 어떤 색인지 파악 가능하다
        for(int i = 1; i <= totalLcm; i++){
            boolean isYellow = true;
            for(int j = 0 ; j < signals.length ; j++){
                int mod = i % period[j];
                
                int green = signals[j][0];
                int yellow = signals[j][1];
                
                if(!(green + 1 <= mod && green + yellow >= mod)){
                    isYellow = false;
                }
            }
            if(isYellow){
                return i;
            }
        }
        
        return -1;
    }
          
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}  