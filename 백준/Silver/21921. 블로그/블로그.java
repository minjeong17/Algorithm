import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        int[] v = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
            if (i < X) sum += v[i];
        }
        
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(sum, 1);
        
        int left = 0;
        int right = X - 1;
        while (true) {
            right++;
            if (right == N) break;
            sum -= v[left];
            sum += v[right];
            
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            
            left++;
        }
        
        int maxV = Integer.MIN_VALUE;
        int period = 0;
        for (int c : cnt.keySet()) {
            if (c > maxV) {
                maxV = c;
                period = cnt.get(c);
            }
        }
        
        if (maxV == 0) System.out.println("SAD");
        else {
            System.out.println(maxV);
            System.out.println(period);
        }
    }
}