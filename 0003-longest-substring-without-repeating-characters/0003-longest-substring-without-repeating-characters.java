// 문자열 s에서 가장 긴 부분 문자열을 구해라. 근데 중복 문자가 있으면 안됨
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        StringBuilder result = new StringBuilder();


        for(int i = 0; i < s.length(); i++){
            int idx = i;
            StringBuilder sb = new StringBuilder();

            while(idx < s.length() && !sb.toString().contains(String.valueOf(s.charAt(idx)))){
                sb.append(s.charAt(idx));
                idx++;
            }

            if(result.length() < sb.length()){
                result = new StringBuilder(sb);
            }
        }

        return result.toString().length();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna