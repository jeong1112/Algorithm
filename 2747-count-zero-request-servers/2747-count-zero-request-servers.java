import java.util.*;
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int[] answer = new int[queries.length];

        // log를 시간 순으로 정렬하여 모든 것을 시간을 기준으로 볼 것이다.
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int[][] queryArr = new int[queries.length][2];

        // queries가 시간 순으로 주어진다는 보장이 없기 때문에 원본 인덱스를 저장하고, 시간 순으로 정렬한다.
        for(int i = 0; i < queries.length; i++){
            queryArr[i][0] = queries[i];
            queryArr[i][1] = i;
        }

        Arrays.sort(queryArr, (a, b) -> a[0] - b[0]);

        int activeServer = 0;
        int left = 0;
        int right = 0;

        int[] serverRequest = new int[n + 1];
        
        for(int[] q : queryArr){

            int query = q[0];
            int originalIndex = q[1];

            int startTime = query - x;
            int endTime = query;
            
            // 구간의 끝 시간 이하의 로그들을 다 추가한다.
            while(right < logs.length && logs[right][1] <= endTime){
                int serverId = logs[right][0];
                serverRequest[serverId]++;

                if(serverRequest[serverId] == 1){
                    activeServer++;
                }
                right++;
            
            }

            // 구간의 시작 시간 미만의 로그들을 다 삭제한다.
            while(left < logs.length && logs[left][1] < startTime){
                int serverId = logs[left][0];
                serverRequest[serverId]--;

                if(serverRequest[serverId] == 0){
                    activeServer--;
                }
                left++;
            }

            answer[originalIndex] = n - activeServer;
        }
        
        return answer;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna