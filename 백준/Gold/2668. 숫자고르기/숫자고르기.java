import java.io.*;
import java.util.*;

public class Main {
    
    public static int[] nums;
    public static Set<Integer> tmpSet = new HashSet<>();
    public static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        nums = new int[N+1];

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
        }
        
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                tmpSet.clear();
                if (isCycle(i)) {
                    for (int t : tmpSet) visited[t] = true;
                    visited[i] = true;
                }
            }
        }
        
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                ans.append(i).append("\n");
                cnt++;
            }
        }
        
        System.out.println(cnt);
        System.out.println(ans.toString());
    }
    
    public static boolean isCycle(int n) {
        int curr = n;
        while (true) {
            if (!visited[nums[curr]]) {
                if (curr == nums[curr] && nums[curr] != n) return false;
                curr = nums[curr];
                if (tmpSet.contains(curr)) return false;
                tmpSet.add(curr);
                if (curr == n) return true;
            } else {
                return false;
            }
        }
    }
}