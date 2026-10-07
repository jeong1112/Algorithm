class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(long x = 1; x <= r2 ; x++){
           // x좌표마다 가능한 y좌표의 개수들을 구한다. 
           // 최대 y값과 최소 y값을 정수로 나타내서 그 차이를 구하면 된다.
           // x^2 + y^2 = r^2이니까 y^2 = r^2 - x^2
            long maxY = (long)Math.floor(Math.sqrt((long)r2 * r2 - x * x));
            
            long minY = 0;
            
            if(x < r1){
                minY = (long)Math.ceil(Math.sqrt((long) r1 * r1 - x * x));
            }
            
            answer += maxY - minY + 1;
            
        }
        
        
        return answer * 4;
    }
}