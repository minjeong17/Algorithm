import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        boolean[] isPrime = new boolean[1000000+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= 1000000; i++) {
            for (int j = i*2; j <= 1000000; j+=i) {
                isPrime[j] = false;
            }
        }
        
        String tmp = Integer.toString(n, k);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.length(); i++){
            char ch = tmp.charAt(i);
            if (ch != '0') {
                sb.append(ch);
            } else {
                if (sb.length() != 0) {
                    long t = Long.parseLong(sb.toString());
                    if (t <= 1000000) {
                        if (isPrime[(int) t]) answer++;
                    } else {
                        if (findIsPrime(t)) answer++;
                    } 
                    sb.setLength(0);
                }
            }
            
        }

        if (sb.length() != 0) {
            long t = Long.parseLong(sb.toString());
            if (t <= 1000000) {
                if (isPrime[(int) t]) answer++;
            } else {
                if (findIsPrime(t)) answer++;
            } 
        }
        
        return answer;
    }
    
    public boolean findIsPrime (long n) {
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}