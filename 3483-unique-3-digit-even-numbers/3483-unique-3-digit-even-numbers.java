import java.util.*;

class Solution {
    public int totalNumbers(int[] digits) {
        int answer = 0;

        int[] cnt = new int[10];
        boolean hasEven = false;
        for (int n : digits) {
            cnt[n]++;

            if (n % 2 == 0) hasEven = true;
        }

        if (!hasEven) return 0;

        for (int n = 0; n < 10; n++) {
            if (n % 2 == 1 || cnt[n] == 0) continue;

            cnt[n]--;

            for (int h = 1; h < 10; h++) {
                if (cnt[h] == 0) continue;

                cnt[h]--;
                for (int t = 0; t < 10; t++) {
                    if (cnt[t] > 0) answer++;
                } 
                cnt[h]++;
            }

            cnt[n]++;
        }

        return answer;
    }
}