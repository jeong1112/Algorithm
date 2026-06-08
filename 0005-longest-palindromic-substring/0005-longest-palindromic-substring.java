class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }

        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < s.length() - 1; i++){
            int oddPalindrome = getPalindromeLength(s, i ,i);
            int evenPalindrome = getPalindromeLength(s, i, i + 1);

            int max = Math.max(oddPalindrome, evenPalindrome);
            
            int start = i - (max - 1) / 2;
            int end = i + max / 2;

            if(max > answer.length()){
                answer.replace(0, answer.length(), s.substring(start, end + 1));
            }

        }

        return answer.toString();
    }

    private int getPalindromeLength(String s, int p1, int p2){
        while(p1 >= 0 && p2 < s.length() && s.charAt(p1) == s.charAt(p2)){
            p1--;
            p2++;
        }

        return p2 - p1 - 1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna