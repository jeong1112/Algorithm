class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] answer = new int[k];
        int start = Math.max(0, k - nums2.length);
        int end = Math.min(k, nums1.length);

        for(int i = start; i <= end; i++){
            int[] arr1 = pickMaxArr(i, nums1);
            int[] arr2 = pickMaxArr(k - i, nums2);

            int[] candidate = mergeArr(arr1, arr2);

            if (isGreater(candidate, 0, answer, 0)) {
                answer = candidate;
            }
        }

        return answer;

    }

    private int[] pickMaxArr(int size, int[] arr){
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();

        int removeCount = arr.length - size;

        for(int num : arr){
            while(!stack.isEmpty() && stack.peek() < num && removeCount > 0){
                stack.pop();
                removeCount--;
            }
            stack.push(num);
        }

        for(int i = 0; i < size; i++){
            result[i] = stack.get(i);
        }

        return result;
    }

    private int[] mergeArr(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        int p1 = 0;
        int p2 = 0;
        int idx = 0;

        while (idx < result.length) {
            if (isGreater(arr1, p1, arr2, p2)) {
                result[idx++] = arr1[p1++];
            } else {
                result[idx++] = arr2[p2++];
            }
        }

        return result;

    }
    

    private boolean isGreater(int[] arr1, int p1, int[] arr2, int p2) {
    while (p1 < arr1.length && p2 < arr2.length) {
        if (arr1[p1] > arr2[p2]) {
            return true;
        } else if (arr1[p1] < arr2[p2]) {
            return false;
        }

        p1++;
        p2++;
    }

    return p1 != arr1.length;
}

}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna