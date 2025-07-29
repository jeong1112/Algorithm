import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int size = diffs.length;
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            long temp = limit;

            for (int i = 0; i < size; i++) {
                if (diffs[i] <= mid) {
                    temp -= times[i];
                } else {
                    int diff = diffs[i] - mid;
                    int prevTime = (i == 0 ? 0 : times[i - 1]);
                    temp -= (long)(times[i] + prevTime) * diff + times[i];
                }

                if (temp < 0) break;
            }

            if (temp >= 0) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1; 
            }
        }

        return answer;
    }
}