class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {

        long answer = 0;

        Arrays.sort(nums);

        int n = nums.length;

        int mid = n / 2; // median의 인덱스

        if(nums[mid] >= k){
            for(int i = mid; i >= 0 && nums[i] >= k; i--){
                answer += (nums[i] - k);
            }
        }
        else{
            for(int i = mid; i < n && nums[i] < k; i++){
                answer += (k - nums[i]);
            }
        }

        return answer;

    }

}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna