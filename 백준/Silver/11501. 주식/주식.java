import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o2[0] - o1[0];
            });  // o1[0] : nums, o1[1] : index
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
                pq.add(new int[] {nums[i], i});
            }
            
            int idx = 0;
            long profit = 0L;
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                
                if (curr[1] >= idx) {
                    long buy = 0L;
                    for (int i = idx; i < curr[1]; i++) {
                        buy += nums[i];
                    }
                    
                    profit += (long)curr[0] * (curr[1] - idx) - buy;
                    idx = curr[1] + 1;
                }
            }
            
            ans.append(profit);
            if (t < T - 1) ans.append("\n");
        }
        
        System.out.println(ans.toString());
    }
}