class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            System.out.println(n);
            
            int tmp = n / a;
            answer += b * tmp;
            
            n = n - tmp*a + tmp*b;
        }
        
        return answer;
    }
}