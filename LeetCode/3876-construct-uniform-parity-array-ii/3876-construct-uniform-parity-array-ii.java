import java.util.*;

class Solution {
    public boolean uniformArray(int[] nums1) {
        int minN = Integer.MAX_VALUE;
        boolean hasOdd = false;
        for (int n : nums1) {
            minN = Math.min(minN, n);

            if (n % 2 == 1) hasOdd = true;
        }

        if (minN % 2 == 0 && hasOdd) return false;

        return true;
    }
}