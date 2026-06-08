// 짝수 n이 주어진다. n은 집의 수를 나타낸다. 그리고 n x 3 크기의 cost 배열이 주어진다.
// cost[i][j]는 i번의 집을 j + 1의 색으로 칠하는 비용이다.
// 인접한 집은 같은 색으로 칠해지면 안된다.
// 집들이 일렬로 있을 때, 양쪽 끝에서 같은 거리만큼 떨어진 집끼리는 같은 색으로 칠하면 안 된다.
// 예를 들어 0,5는 왼쪽에서 0칸 오른쪽에서 0칸이고 1,4는 왼쪽 오른쪽 1칸 이렇게인데, 얘네들끼리는 같은 색으로 칠하면 안됨
// 이 조건을 만족해서 집을 칠하는 최소 비용을 구해라.
// 색은 무조건 3개로 고정이다.
// i번 집과 n - i - 1번 집을 동시에 칠한다.
 
class Solution {
    int[][] cost;
    int n;
    long[][][] dp;

    // 색은 0, 1, 2로 세 가지이다.
    public long minCost(int n, int[][] cost) {
        this.n = n;
        this.cost = cost;

        // 색은 0,1,2지만 안칠해진 경우를 표시해야 해서 크기 4로 만든다.
        dp = new long[n / 2][4][4];

        for(int i = 0; i < n / 2; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        return dfs(0, 3, 3);
    }

    // 양 끝을 한 번에 칠하기 때문에 이전 색을 두 개를 변수로 사용한다.
    private long dfs(int depth, int prevLeft, int prevRight){
        
        if(depth == n / 2){
            return 0;
        }

        if(dp[depth][prevLeft][prevRight] != -1){
            return dp[depth][prevLeft][prevRight];
        }

        int left = depth;
        int right = n - depth - 1;

        long result = Long.MAX_VALUE;

        for(int leftColor = 0; leftColor < 3; leftColor++){
            for(int rightColor = 0; rightColor < 3; rightColor++){
                //여기서 인접조건이랑 다 처리해야된다
                if(leftColor == rightColor){
                    continue;
                }

                // 3이면 처음 칠하는 경우다
                if(prevLeft != 3 && leftColor == prevLeft){
                    continue;
                }

                if(prevRight != 3 && rightColor == prevRight){
                    continue;
                }

                long currentCost = cost[left][leftColor] + cost[right][rightColor];

                long remainCost = dfs(depth + 1, leftColor, rightColor);

                result = Math.min(result, currentCost + remainCost);

            }
        }

        dp[depth][prevLeft][prevRight] = result;
        return result;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna