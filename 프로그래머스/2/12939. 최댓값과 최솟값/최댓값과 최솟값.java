class Solution {
    public String solution(String s) {
        
        String[] nums = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String str : nums) {
            int n = Integer.parseInt(str);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        StringBuilder answer = new StringBuilder();
        answer.append(min).append(" ").append(max);
        return answer.toString();
    }
}