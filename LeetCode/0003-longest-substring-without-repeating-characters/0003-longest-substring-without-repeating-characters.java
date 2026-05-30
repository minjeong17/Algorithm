class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> alpha = new HashSet<>();

        int left = 0;
        int right = 0;
        int answer = 0;

        while (right < s.length()) {
            char curr = s.charAt(right);

            if (!alpha.contains(curr)) {
                alpha.add(curr);
                answer = Math.max(answer, right - left + 1);
                right++;
            } else {
                alpha.remove(s.charAt(left));
                left++;
            }
        }

        return answer;
    }
}