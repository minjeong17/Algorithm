import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        
        boolean[] isPrime = new boolean[n2+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n2; i++) {
            if (isPrime[i]) {
                for (int j = i*2; j <= n2; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        
        int sum = 0;
        int min = -1;
        for (int i = n1; i <= n2; i++) {
            if (isPrime[i]) {
                sum += i;
                if (min == -1) min = i;
            }
        }
        
        if (sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}