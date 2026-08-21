import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int n : nums) cnt.put(n, cnt.getOrDefault(n, 0) + 1);

        System.out.println(cnt);

        List<int[]> sorting = new ArrayList<>();
        for (int n : cnt.keySet()) sorting.add(new int[] {n, cnt.get(n)});

        Collections.sort(sorting, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o2[1] - o1[1];
        });

        for (int i = 0; i < k; i++) {
            answer[i] = sorting.get(i)[0];
        }

        return answer;
    }
}