import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int cntN = 0;
        int cntZero = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (nums[i] < 0) cntN++;
            else if (nums[i] == 0) cntZero++;
        }
        int cntP = nums.length - cntN - cntZero;
        
        Arrays.sort(nums);
        
        int answer = 0;

        if (cntN == 1) {
            if (cntZero == 0) answer += nums[0]; 
        } else {
            for (int i = 0; i < cntN - 1; i+=2) {
                answer += nums[i] * nums[i+1];
            }    

            if (cntN % 2 == 1 && cntZero == 0) answer += nums[cntN - 1];  
        }
                
        for (int i = nums.length - 1; i > cntN + cntZero; i-=2) {
            if (nums[i] * nums[i-1] < nums[i] + nums[i-1]) answer += nums[i] + nums[i-1];
            else answer += nums[i] * nums[i-1];
        }
        
        if (cntP % 2 == 1) answer += nums[cntN + cntZero];
         
        System.out.println(answer);
    } 
}