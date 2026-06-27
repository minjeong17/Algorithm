class Solution {
    int[] citations;
    public int solution(int[] citations) {
        this.citations = citations;
        int answer = Integer.MIN_VALUE;
        
        int left = 0;
        int right = 10000;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (check(mid)) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return answer;
    }
    
    public boolean check(int mid) {
        int cnt = 0;
        for (int c : citations) {
            if (c >= mid) cnt++;
        }
        
        if (cnt >= mid) return true;
        else return false;
    }
}