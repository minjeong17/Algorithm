import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int n : nums) cnt.put(n, cnt.getOrDefault(n, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o2[1] - o1[1];
        });
        
        for (int n : cnt.keySet()) pq.add(new int[] {n, cnt.get(n)});

        for (int i = 0; i < k; i++) {
            answer[i] = pq.poll()[0];
        }

        return answer;
    }
}