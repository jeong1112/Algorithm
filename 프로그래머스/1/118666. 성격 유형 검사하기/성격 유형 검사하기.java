//choices는 1~7까지 있다 4는 모르겠음이다
//survey에서 첫번째 문자가 비동의 선택지, 두번째가 동의 선택지 점수를 가져간다.
//survey랑 choice는 길이가 같다
// RT, CF, JM, AN 순으로 판단
import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        
        Map<Character, Integer> score = new HashMap<>();
        
        //여기서 점수 집계
        for(int i = 0; i < choices.length; i++){
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            
            int userChoice = choices[i];
            
            if(userChoice > 4){
                int previous = score.getOrDefault(c2, 0);
                score.put(c2, previous + Math.abs(4 - userChoice));
            }
            else if(userChoice < 4){
                int previous = score.getOrDefault(c1, 0);
                score.put(c1, previous + (4 - userChoice));
            }
            
        }
        
        //집계된 점수 바탕으로 유형 판단
        //RT, CF, JM, AN
        int Rscore = score.getOrDefault('R', 0);
        int Tscore = score.getOrDefault('T', 0);
        if(Rscore >= Tscore){
            answer += 'R';
        }
        else{
            answer += 'T';
        }
        
        int Cscore = score.getOrDefault('C', 0);
        int Fscore = score.getOrDefault('F', 0);
        if(Cscore >= Fscore){
            answer += 'C';
        }
        else{
            answer += 'F';
        }
        
        int JScore = score.getOrDefault('J', 0);
        int MScore = score.getOrDefault('M', 0);
        if(JScore >= MScore){
            answer += 'J';
        }
        else{
            answer += 'M';
        }
        
        int AScore = score.getOrDefault('A', 0);
        int NScore = score.getOrDefault('N', 0);
        if(AScore >= NScore){
            answer += 'A';
        }
        else{
            answer += 'N';
        }
        
        
        return answer;

    }
}