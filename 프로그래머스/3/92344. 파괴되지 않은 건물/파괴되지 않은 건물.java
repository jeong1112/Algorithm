//skill의 각 행은 [type, r1, c1, r2, c2, degree]형태를 가지고 있습니다.
// type 1이면 공격, 2면 회복
// r1, c1부터 r2, c2까지 degree만큼 공격 혹은 회복
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] sum = new int[board.length + 1][board[0].length + 1];

        for(int i = 0; i < skill.length; i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            degree = (type == 1) ? (-1) * degree : degree;
            
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] += degree * (-1);
            sum[r2 + 1][c1] += degree * (-1);
            sum[r2 + 1][c2 + 1] += degree;
        
        }
        
        for(int j = 0; j < board[0].length + 1; j++){
            for(int i = 0; i < board.length; i++){
                sum[i+1][j] += sum[i][j];
            }
        }
        
        for(int i = 0; i < board.length + 1; i++){
            for(int j = 0; j < board[0].length; j++){
                sum[i][j+1] += sum[i][j];
            }
        }
        
        
        
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] += sum[i][j];
                if(board[i][j] > 0){
                    answer++;
                }
            }
        }
        
        return answer;
        
    }
}