class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        for(int i = 1; i < max.length; i++){
            max[i] = Math.max(max[i - 1], nums[i]);
        }

        min[min.length - 1] = nums[nums.length - 1];
        for(int i = min.length - 2; i >= 0; i--){
            min[i] = Math.min(min[i + 1], nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            if((max[i] - min[i]) <= k){
                return i;
            }
        }
        
        return -1;
    }


}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna