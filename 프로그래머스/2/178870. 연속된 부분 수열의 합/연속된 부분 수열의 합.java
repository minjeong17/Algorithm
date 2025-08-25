class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int len = Integer.MAX_VALUE;
        while (left < sequence.length) {
            if (sum > k) {
                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                if (right == sequence.length - 1) {
                    sum -= sequence[left];
                    left++;
                } else if (right + 1 <= sequence.length-1) {
                    right++;
                    sum += sequence[right];
                }
            } else {
                if (right - left < len) {
                    answer[0] = left;
                    answer[1] = right;
                    len = right - left;
                }
                
                sum -= sequence[left];
                left++;
            }
            
            // if (left == sequence.length) break;
        }
        
        return answer;
    }
}