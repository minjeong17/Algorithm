class Solution {
    public int[] solution(long n) {
        
        String str = String.valueOf(n);
        int[] answer = new int[str.length()];
        
        for (int i = str.length()-1, idx = 0; i >= 0; i--) {
            answer[idx++] = Integer.parseInt(str.charAt(i)+"");
        }

        return answer;
    }
}