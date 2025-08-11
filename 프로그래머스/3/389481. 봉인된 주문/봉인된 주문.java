import java.util.*;
class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        long[] banNum = new long[bans.length];
        
        for(int i = 0; i < banNum.length ; i++){
            banNum[i] = convertStrToNum(bans[i]);
        }
        
        Arrays.sort(banNum);
        
        for(long bn : banNum) if(bn <= n) n++;
        
        answer = convertNumToStr(n);
        
    
        return answer;
        
        
    }
    
    private long convertStrToNum(String str){
        //문자열을 숫자로 변환
        int size = str.length();
        long num = 0;
        for(int i = 0 ; i < size ; i++){
            num += (str.charAt(i) - 'a' + 1) * Math.pow(26, size - 1 - i);
        }
        return num;
    }
    
    private String convertNumToStr(long num){
        //숫자를 문자열로 변환 
        String str = "";
        
        while(num > 0){
             str = String.valueOf((char)((num - 1) % 26 + 1 + 96)) + str;
             num = (num - 1) / 26;
        }
        return str;
        
    }
}