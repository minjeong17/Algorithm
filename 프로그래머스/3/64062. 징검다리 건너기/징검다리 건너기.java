import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;  

        while (left < right) {
            int mid = (left + right) / 2;
            if (check(mid, k, stones)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    
    public boolean check(int n, int k, int[] stones) {
        int cnt = 0;
        for (int s : stones) {
            if (s <= n) {
                cnt++;
                if (cnt == k) return true;
            } else cnt = 0;
        }
        
        return false;
    }
}
