// 문자열 s에서 가장 긴 부분 문자열을 구해라. 근데 중복 문자가 있으면 안됨
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;

        // 현재 pick된 문자열들을 담는다. 
        Set<Character> set = new HashSet<>();

        int left = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna