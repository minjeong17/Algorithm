import java.util.*;

class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int mod = (int) Math.pow(10, 9) + 7;
        System.out.println(mod);

        int[] sumArr = new int[n];
        sumArr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = arr[i] + sumArr[i-1];
        }

        int cntOdd = 0;
        int cntEven = 0;
        int answer = 0;
        for (int s : sumArr) {
            if (s % 2 == 0) {
                answer = (answer + cntOdd) % mod;
                cntEven++;
            } else {
                answer = (answer + cntEven + 1) % mod;
                cntOdd++;
            }
        }

        return answer;
    }
}