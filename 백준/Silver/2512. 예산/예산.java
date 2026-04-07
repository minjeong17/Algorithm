import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] budgets = new int[N];
        int maxB = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            maxB = Math.max(maxB, budgets[i]);
        }
        int M = Integer.parseInt(br.readLine());
        
        int answer = Integer.MIN_VALUE;

        int left = 0;
        int right = maxB;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid, budgets, M)) {
                left = mid + 1;
		        answer = Math.max(answer, mid);
            } else right = mid - 1;
        }
        
        System.out.println(answer);
    }
    
    public static boolean check(int b, int[] budgets, int M) {
        int tmp = 0;
        for (int budget : budgets) {
            if (budget <= b) tmp += budget;
            else tmp += b;
        }
        
        if (tmp <= M) return true;
        else return false;
    }
}