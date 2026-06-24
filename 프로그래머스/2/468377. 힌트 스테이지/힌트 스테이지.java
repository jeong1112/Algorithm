/*
    i번 힌트권은 i번 스테이지에서만 사용 가능하다.
    하나의 스테이지에서는 최대 n-1개의 힌트권을 사용할 수 있다.
    처음에는 힌트권이 없다.
    마지막 스테이지를 제외한 각 스테이지에서 힌트 번들을 1개까지 살 수 있다. 
    힌트 번들은 이후 스테이지의 힌트권을 제공한다.
    힌트 번들에는 힌트권이 k장 들어있고, 같은 번호일 수도 있다.
    i번 스테이지에서 판매하는 힌트 번들에는 항상 i+1번 이상의 힌트권만 있다.
    모든 스테이지를 해결하는데 필요한 최소 비용을 구해라
        
*/
class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int answer = Integer.MAX_VALUE;
        /*
            각 스테이지에서 힌트를 구매했냐 구매 안했냐에 따른 경우를 다 고려한다.
            0부터 2^n-1까지 반복한다. 0이면 힌트를 아무것도 안쓴것, 2^n-1이면 모든
            힌트를 다 쓴것이다.
            예시를 보면 n = 5이다. 1111이면 1에서 4까지 힌트를 모두 구매한것, 
            그니까 이 경우에서 최솟값을 갱신한다는거다.
            총 비용에서 hint[i][0]을 다 더해야된다.
            그리고 mask에서 1인 부분은 힌트를 구매한거니까 힌트 개수에 추가시켜야 한다.
            그리고 힌트 개수에 따른 비용을 더해줘야 한다. 힌트 개수를 담아놓을 배열
        */
        int n = cost.length;
        
        for(int mask = 0; mask < (1 << n); mask++){
            int totalCost = 0;
            int[] hintCount = new int[n + 1];
            // 힌트 개수를 세서 늘려주고, 그에 따른 스테이지 해결 비용을 총 비용에 더해준다.
            for(int i = 1; i <= n; i++){
                // 그니까 mask가 1010으로 주어지면 2번 스테이지, 4번 스테이지에서 힌트삼
                
                // i번 스테이지에서 힌트권을 구매한 경우이다.
                if(i < n && (mask & (1 << (i - 1))) != 0){
                    totalCost += hint[i - 1][0];
                    // 이제 힌트권 개수에 따른 스테이지 해결 비용만 더해주면 된다.
                    
                    for(int j = 1; j < hint[i - 1].length; j++){
                        int hintNum = hint[i - 1][j];
                        hintCount[hintNum]++;
                        
                        if(hintCount[hintNum] > n - 1){
                            hintCount[hintNum] = n - 1;
                        }
                    }       
                }
                
                totalCost += cost[i - 1][hintCount[i]];
            }
            
            answer = Math.min(answer, totalCost);
        }
    
        return answer;
    }
    
    
    
}