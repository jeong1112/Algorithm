// n은 3의 배수이다. 크기가 n인 배열이 주어진다. 배열을 3개짜리 배열 n/3개로 나누어라
// 나누는 조건은 다음과 같다. 모든 원소 간의 차이는 k 이하이다.
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;

        int[][] answer = new int[n / 3][3];
        
        Arrays.sort(nums);

        for(int i = 0; i < n; i += 3){
            if(nums[i + 2] - nums[i] <= k){
                answer[i / 3][0] = nums[i];
                answer[i / 3][1] = nums[i + 1];
                answer[i / 3][2] = nums[i + 2];
            }
            else{
                return new int[0][];
            }
        }

        return answer;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna