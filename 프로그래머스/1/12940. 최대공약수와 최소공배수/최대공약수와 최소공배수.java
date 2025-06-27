class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int gcd = 0;
        for (int i = Math.min(n, m); i >= 1; i--) {
            if (n % i == 0 && m % i == 0) {
                gcd = i;
                break;
            }
        }
        
        int lcm = gcd * (n / gcd) * (m / gcd);
        
        answer[0] = gcd;
        answer[1] = lcm;
        
        return answer;
    }
}