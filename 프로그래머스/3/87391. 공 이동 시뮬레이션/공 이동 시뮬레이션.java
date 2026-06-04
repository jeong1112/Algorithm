// 벽을 만나면 멈춘다.
// 모든 시작점에 대해서 시뮬레이션한다. 그중에서 시뮬레이션 결과 x행 y열에 도착할 수 있는 경우의 수
// 쿼리 0 : 왼쪽
// 쿼리 1 : 오른쪽
// 쿼리 2 : 위로 감
// 쿼리 3 : 아래로 감
// 그냥 시키는대로?
class Solution {
 
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long rowStart = x;
        long rowEnd = x;
        long colStart = y;
        long colEnd = y;
        
        for(int i = queries.length - 1; i >= 0; i--){
            int dir = queries[i][0];
            int dist = queries[i][1];
            
            // 왼쪽
            if(dir == 0){
                if(colStart != 0){
                    colStart += dist;
                }
                colEnd += dist;
                
                if(colStart >= m) return 0;
                if(colEnd >= m) colEnd = m - 1;
            }
            
            // 오른쪽
            else if(dir == 1){
                if(colEnd != m - 1){
                    colEnd -= dist;
                }
                colStart -= dist;
                
                if(colEnd < 0) return 0;
                if(colStart < 0) colStart = 0;
            }
            
            // 위
            else if(dir == 2){
                if(rowStart != 0){
                    rowStart += dist;
                }
                rowEnd += dist;
                
                if(rowStart >= n) return 0;
                if(rowEnd >= n) rowEnd = n - 1;
            }
            
            // 아래
            else if (dir == 3){
                if(rowEnd != n - 1){
                    rowEnd -= dist;
                }
                rowStart -= dist;
                
                if(rowEnd < 0) return 0;
                if(rowStart < 0) rowStart = 0;
            }
        }
        return (rowEnd - rowStart + 1) * (colEnd - colStart + 1);
    }
  
}