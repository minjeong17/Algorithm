class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (long i = 0; i <= d; i+=k) {
            long t = (long)d * d - i * i;
                        
            answer += ((long) Math.sqrt(t) / k) + 1;
        }
        
        return answer;
    }
}