import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        if (N == 1) {
            System.out.println(0);
            return;
        }
        
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;
        
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) primes.add(i);
            for (int j = i*2; j <= N; j += i) {
                isPrime[j] = false;
            }
        }

        int[] prefixSum = new int[primes.size()];
        prefixSum[0] = primes.get(0);
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + primes.get(i);
        }

        int left = 0;
        int answer = 0;
        for (int right = 0; right < prefixSum.length; right++) {
            if (prefixSum[right] == N) answer++;
            
            while (prefixSum[right] - prefixSum[left] > N) {
                left++;
            }
            
            if (prefixSum[right] - prefixSum[left] == N) answer++;
        }
        
        System.out.println(answer);        
    } 
}