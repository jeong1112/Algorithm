import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String convertedNum = Integer.toString(n,k);
        String[] arr = convertedNum.split("0");
        for(String s : arr){
            if(s.equals("")) continue;
            long num = Long.parseLong(s);
            if(isPrimeNumber(num)){
                answer++;
            }
        }
        
        return answer;
    }
    private boolean isPrimeNumber(long n){
        if(n <= 1){
            return false;
        }
        
        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}