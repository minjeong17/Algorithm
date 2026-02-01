import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] liqs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liqs[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = N-1;
        int minL = 0;
        int minR = N-1;
        int minSum = Integer.MAX_VALUE;
        while (left < right) {
            int sum = liqs[left] + liqs[right];
            if (sum == 0) {
                minL = left;
                minR = right;
                break;
            } else {
                if (Math.abs(sum-0) < Math.abs(minSum-0)) {
                    minL = left;
                    minR = right;
                    minSum = sum;
                }
                if (sum > 0) right--;
                else left++;
            } 
        }
        
        System.out.println(liqs[minL] + " " + liqs[minR]);
    }
}