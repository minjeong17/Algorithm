import java.io.*;
import java.util.*;

class Main {
    
    static int N, K;
    static int[] nums;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int answer = 1;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < N; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            while (cnt.get(nums[i]) > K) {
                cnt.put(nums[left], cnt.get(nums[left]) - 1);
                left++;
            }
            answer = Math.max(answer, i - left + 1);
        }
        
        System.out.println(answer);
    }
}