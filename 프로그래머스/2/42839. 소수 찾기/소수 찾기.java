import java.util.*;

class Solution {
    char[] nums;
    int[] sel;
    boolean[] visited, isPrime;
    Set<Integer> primes;
    public int solution(String numbers) {        
        nums = numbers.toCharArray();
        
        int totalNum = 1;
        for (int i = 0; i < nums.length; i++) totalNum *= 10;
        isPrime = new boolean[totalNum];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;
        for (int i = 2; i * i <= totalNum; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < totalNum; j += i) {
                    isPrime[j] = false;
                }
                
            }
            
        }
                
        primes = new HashSet<>();
        for (int s = 1; s <= numbers.length(); s++) {
            sel = new int[s];   
            visited = new boolean[nums.length];
            
            perm(0, s);
        }
        
        return primes.size();
    }
    
    public void perm(int idx, int size) {
        if (idx == size) {
            int num = 0;
            for (int i = 0; i < size; i++) {
                num = num * 10 + sel[i];
            }
                        
            if (isPrime[num]) primes.add(num);
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sel[idx] = nums[i] - '0';
                perm(idx + 1, size);
                visited[i] = false;
            }
        }
    }
}