import java.util.*;
class Solution {
    static int N;
    static int maxScoreDiff = Integer.MIN_VALUE;
    static int[] ryanInfo;
    static int[] answer;
    public int[] solution(int n, int[] info) {

        N = n;
        
        ryanInfo = new int[11];
        answer = new int[11];
        dfs(0, info);
        
        if(maxScoreDiff == -1){
            int[] arr = {-1};
            return arr;
        }
    
        return answer;
    }

    private static void dfs(int depth, int[] info){
        if(depth == N){
            //점수 차이 구해서 최댓값 갱신
            int diff = getDiff(info);
            if(diff >= maxScoreDiff){
                maxScoreDiff = diff;
                answer = ryanInfo.clone();
            }
            return;
        }
        
        //여기서 쏜 화살의 경우의 수 구해야 함
        for(int i = 0 ; i < info.length && ryanInfo[i] <= info[i] ; i++){
            ryanInfo[i]++;
            dfs(depth + 1, info);
            ryanInfo[i]--;
        }
        
    }
    
    private static int getDiff(int[] info){
        int ryanCnt = 0;
        int appeachCnt = 0;
        
        for(int i = 0 ; i < info.length ; i++){
            if(info[i] == 0 && ryanInfo[i] == 0) continue;
            if(info[i] >= ryanInfo[i]){
                appeachCnt += (10 - i);
            }
            else{
                ryanCnt += (10 - i);
            }
        }
        
        int diff = ryanCnt - appeachCnt;
        
        if(diff <= 0){
            return -1;
        }
        
        return diff;
        
    }
}