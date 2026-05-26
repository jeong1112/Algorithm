// 비밀 코드로 가능한 정수 조합?
// 시스템 응답만 보고 비밀 코드 정답 후보 개수를 가려내라는 거네
// 모든 비밀코드 경우의 수를 만들어 조건을 만족하는지 검사한다.

class Solution {
    static int n;
    static int answer = 0;
    static int[][] q;
    static int[] ans;
    

    public int solution(int n, int[][] q, int[] ans) {
        int[] comb = new int[5];
        
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        combination(0, 0, comb);
        
        return answer;
    }
    
    private void combination(int start, int depth, int[] comb){
        
        if(depth == 5){
            if(isValidComb(comb)){
                answer++;
            }
            return;
        }
        
        for(int i = start + 1; i <= n ; i++){
            comb[depth] = i;
            combination(i, depth + 1, comb);
        }
        
    }
    
    private boolean isValidComb(int[] comb){
        for(int i = 0; i < q.length; i++){
            int count = 0;
            for (int a : comb) {
                for (int b : q[i]) {
                    if (a == b) {
                        count++;
                    }
                }
            }
            
            if(count != ans[i]){
                return false;
            }
        }
        return true;
    }
}