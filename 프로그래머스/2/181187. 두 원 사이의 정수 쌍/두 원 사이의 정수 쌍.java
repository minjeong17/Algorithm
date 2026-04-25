class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long x0 = (r2 - r1 + 1) * 2;
        for (long i = 1; i <= r2; i++) {
            long maxY = (long) Math.sqrt(1L * r2 * r2 - i * i);
            
            if (i < r1) {
                long minY = (long) Math.ceil(Math.sqrt(1L * r1 * r1 - i * i));
                answer += (maxY - minY + 1) * 2;
            } else {
                answer += maxY * 2 + 1;
            }
        }
                
        answer = answer * 2 + x0;
        
        return answer;
    }
}