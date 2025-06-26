class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        
        int idx = 0;
        for (int n : arr) {
            if (n != min) answer[idx++] = n;
        }
        
        return answer.length == 0 ? new int[] {-1} : answer;
    }
}