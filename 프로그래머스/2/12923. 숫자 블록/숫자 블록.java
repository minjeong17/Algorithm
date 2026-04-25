class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];
        
        int idx = 0;
        for (long num = begin; num <= end; num++) {
            answer[idx++] = find(num);
        }
        
        return answer;
    }
    
    public int find(long num) {
        if (num == 1) return 0;
        
        int res = 1;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                if (num / i <= 10000000) return (int) (num / i);
                res = (int) i;
            }
        }
        
        return res;
    }
}