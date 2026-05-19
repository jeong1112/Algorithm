import java.util.*;
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {        
        int n = gas.length;

        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            int diff = gas[i] - cost[i];

            totalCost += diff;
            tank += diff;
            
            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }

        return totalCost >= 0 ? start : -1;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna