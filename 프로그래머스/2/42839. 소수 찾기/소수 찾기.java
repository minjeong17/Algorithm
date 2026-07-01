import java.util.*;

class Solution {
    int answer;
    boolean[] isPrime;
    int[] nums;
    int[] tmp;
    boolean[] visited;
    Set<Integer> set;
    public int solution(String numbers) {
        answer = 0;
        
        int len = numbers.length();
        
        int maxNum = (int)Math.pow(10, len) - 1;
        isPrime = new boolean[maxNum + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;
        for (int i = 2; i * i <= maxNum; i++) {
            for (int j = 2; i * j <= maxNum; j++) {
                isPrime[i*j] = false;
            }
        }
        
        nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = numbers.charAt(i) - '0';
        }
        
        set = new HashSet<>();
        for (int i = 1; i <= len; i++) {
            tmp = new int[i];
            visited = new boolean[len];
            perm(0);
        }
        
        return answer;
    }
    
    public void perm (int idx) {
        if (idx == tmp.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.length; i++) {
                sb.append(tmp[i]);
            }
            int n = Integer.parseInt(sb.toString());
            
            if (!set.contains(n)) {
                set.add(n);
                if (isPrime[n]) answer++;
            }
            
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                tmp[idx] = nums[i];
                visited[i] = true;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
}