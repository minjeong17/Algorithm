import java.util.*;

class Solution {

    int[] nums;
    boolean[] isPrime;
    boolean[] visited;
    int len;
    
    int[] sel;
    boolean[] visitedP;
    
    int answer = 0;
    
    public int solution(String numbers) {
        
        len = numbers.length();
        nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(numbers.charAt(i)+"");
        }
        
        int tLen = (int)Math.pow(10, len+1);
        isPrime = new boolean[tLen];
        visited = new boolean[tLen];
        
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i * i <= tLen; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < tLen; j+=i) {
                    isPrime[j] = false;
                }
            }
        } 
        
        for (int i = 1; i <= len; i++) {
            sel = new int[i];
            visitedP = new boolean[len];
            perm(0, i);
        }
        
        return answer;
    }
    
    public void perm(int sidx, int l) {
        if (sidx == l) {
            StringBuilder sb = new StringBuilder();
            for (int s : sel) sb.append(s);
            int n = Integer.parseInt(sb.toString());
            if (!visited[n] && isPrime[n]) {
                visited[n] = true;
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (!visitedP[i]) {
                visitedP[i] = true;
                sel[sidx] = nums[i];
                perm(sidx+1, l);
                visitedP[i] = false;
            }
        }
    }
}