class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int answer = 0;
        for(int i = 0; i < word.length() - 1; i++){
            if(isAlmostEqual(word.charAt(i), word.charAt(i + 1))){
                answer++;
                i++;
            }
        }

        return answer;
    }

    private boolean isAlmostEqual(char c1, char c2){
        return Math.abs(c1 - c2) <= 1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna