// 숙련도가 난이도 이상이면 틀리지 않고 소요 시간만큼 사용
// 숙련도보다 난이도가 높으면 diff - level번 틀린다. 틀릴 때마다 time_cur 시간 사용하고 '추가로' time_prev 사용해서 이전 퍼즐 풀어야 함. 이전 퍼즐은 틀리지 않는다.
// diff-level, 즉 숙련도와 난이도의 차이만큼 틀리고 퍼즐을 풀면 time_cur만큼의 시간 사용하고 푼다. 
// 제한 시간 내에 퍼즐을 해결하기 위한 숙련도의 최솟값. 
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int low = 1;
        int high = 0;
        for (int d : diffs) high = Math.max(high, d);
        
        while(low <= high){
            int mid = (low + high) / 2;
            long time = times[0];
 
            for(int i = 1; i < diffs.length; i++){
                time += times[i];
                
                if(mid < diffs[i]){
                    long tryCount = diffs[i] - mid;
                    long tryTime = times[i] + times[i-1];
                    time += tryCount * tryTime;
                }
            }
            
            if(time <= limit){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
            
        }
        
        return low;
    }
}