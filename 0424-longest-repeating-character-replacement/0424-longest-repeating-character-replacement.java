class Solution {
    public int characterReplacement(String s, int k) {
   
        int answer = 0;
        int l = 0;
        int maxCount = 0;
        int[] count = new int[26];

        for(int r = 0; r < s.length(); r++){
            int index = s.charAt(r) - 'A';
            count[index]++;

            maxCount = Math.max(maxCount, count[index]);

            while(r - l + 1 - maxCount > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            
            answer = Math.max(answer, r - l + 1);
        }

        return answer;
    }

}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna