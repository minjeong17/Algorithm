class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int m = brown + yellow;
        int s = (m + 4 - yellow) / 2;
        
        answer[0] = (s + (int)Math.sqrt(s * s - 4 * m)) / 2;
        answer[1] = (s - (int)Math.sqrt(s * s - 4 * m)) / 2;
        
        return answer;
    }
}