import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i*2; j <= n; j += i) isPrime[j] = false;
            }
        }
        
        List<Integer> primeList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isPrime[i] && n % i == 0) primeList.add(i);
        }
        
        int[] answer = new int[primeList.size()];
        for (int i = 0; i < primeList.size(); i++) {
            answer[i] = primeList.get(i);
        }
        
        return answer;
    }
}