class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int num = 1; num <= number; num++) {
            if (num == 1) answer += 1;
            else {
                int cnt = 0;
                for (int j = 1; j <= Math.sqrt(num); j++) {
                    if (j == Math.sqrt(num)) cnt += 1;
                    else if (num % j == 0) cnt += 2;
                }

                if (cnt > limit) answer += power;
                else answer += cnt;
            }
        }
        
        return answer;
    }
}