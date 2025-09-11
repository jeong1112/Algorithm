import java.util.*;
class Solution {
    
    int[] answer;
    int DICE_NUM = 6;
    int diceCount = 0;
    int maxWin = 0;
    
    public int[] solution(int[][] dice) {
        diceCount = dice.length;
        
        boolean[] visited = new boolean[diceCount];
        visited[0] = true;
        answer = new int[diceCount / 2];
        
        combination(1, 0, visited, dice);
        
        return answer;
    }
    
     public void combination(int index, int count, boolean[] visited, int[][] dice){
         
         if(count == diceCount / 2 - 1){
             
             int[] AScore = getSumDiceScore(true, visited, dice);
             int[] BScore = getSumDiceScore(false, visited, dice);
             
             Arrays.sort(AScore);
             Arrays.sort(BScore);
             
             int AwinCount = getWinCount(AScore, BScore);
             int BwinCount = getWinCount(BScore, AScore);
             
             int answerIdx = 0;
             if(maxWin < AwinCount){
                 maxWin = AwinCount;
                 for(int i = 0; i < visited.length; i++){
                     if(visited[i]) answer[answerIdx++] = i + 1;
                 }
             }
             
             answerIdx = 0;
             
             if(maxWin < BwinCount) {
                maxWin = BwinCount;
                for(int i=0; i<visited.length; i++) {
                    if(!visited[i]) answer[answerIdx++] = i + 1;
                }
            }
            
            return;
             
         }
         
         for(int i = index; i < visited.length; i++){
             if(!visited[i]){
                 visited[i] = true;
                 combination(i + 1, count + 1, visited, dice);
                 visited[i] = false;
             }
         }
         
         
     }
    
     public int getWinCount(int[] score1, int[] score2) {
        int winCount = 0;
        
        for(int i=0; i<score1.length; i++) {
            for(int j=0; j<score2.length; j++) {
                if(score1[i] > score2[j]) {
                    winCount++;
                } else break;
            }
        }
        
        return winCount;
    }
    
    public int[] getSumDiceScore(boolean team, boolean[] visited, int[][] dice) {
        int[] arr = new int[(int) Math.pow(DICE_NUM, diceCount/2)];
        int[] select = new int[diceCount / 2];
        int index = 0;
        idx = 0;
        
        for(int i=0; i< diceCount; i++) {
            if(visited[i] == team) {
                select[index++] = i;
            }
        }
        

        permutation(0, arr, select, 0, dice);
        
        return arr;
    }
    
    int idx;
    public void permutation(int cnt, int[] arr, int[] select, int sum, int[][] dice) {
        if(cnt == diceCount/2) {
            arr[idx++] = sum;
            return;
        }
        
        for(int i=0; i<DICE_NUM; i++) {
            permutation(cnt+1, arr, select, sum + dice[select[cnt]][i], dice);
        }
    }
}