import java.util.*;

class Solution {
    public int solution(int[] cards) {
        
        int open = cards.length;
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] > 0) {
                int size = 1;
                int idx = cards[i] - 1;
                cards[i] = -1;
                while (cards[idx] > 0) {
                    int tmp = idx;
                    idx = cards[idx] - 1;
                    cards[tmp] = -1;
                    size++;
                }
                
                sizes.add(size);
            }
        }
        
        if (sizes.size() <= 1) return 0;
        else {
            Collections.sort(sizes);
            return sizes.get(sizes.size() - 1) * sizes.get(sizes.size() - 2);
        }
    }
}