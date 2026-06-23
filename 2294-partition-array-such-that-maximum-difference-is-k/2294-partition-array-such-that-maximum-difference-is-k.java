/*
    정수 배열 nums와 정수 k가 주어진다. nums를 부분 배열로 쪼개야 하는데 각 부분 배열에 nums의 원소가 단 한번만 등장해야 한다. 
    부분 배열의 최소 수를 반환해야 한다. 근데 각 부분 배열의 최댓값과 최솟값의 차이가 최대 k여야 한다. 원본 배열에서의 순서는 바뀌면 안된다.
*/
class Solution {
    public int partitionArray(int[] nums, int k) {
        /*
            원본 인덱스는 저장한채 배열을 정렬해서 최솟값을 기준으로 차이가 k 이하인 놈들을 뽑는다.
            그럼 마지노선이 나오겠지? 그리고 바로 그 다음 값을 새로운 최솟값으로 잡아 또 넣는다.
            이 과정을 배열에 남은 원소가 없을 때까지 반복한다.
            max - min <= k, min >= max - k
        */

        int answer = 1;

        Arrays.sort(nums);

        int idx = 0;
        int min = nums[0];

        while(idx <= nums.length - 2){
            idx++;
            // 최댓값과 최솟값의 차이가 k보다 크면 새로운 부분집합으로 넘어가야 한다.
            if(min < nums[idx] - k){
                min = nums[idx];
                answer++;
            }
        }

        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna