import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int len = elements.length;
        
        int[] newElem = new int[len*2];
        for (int i = 0; i < len; i++) {
            newElem[i] = elements[i];
            newElem[i+len] = elements[i];
        }
        
        Set<Integer> sums = new HashSet<>();
        for (int ii = 0; ii < len; ii++) {
            for (int l = 0; l < len; l++) {
                int left = ii;
                int right = left + l;

                int tmp = 0;
                for (int i = left; i < right; i++) {
                    tmp += newElem[i];
                }

                sums.add(tmp);
            }
        }
        
        return sums.size();
    }
}