import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        list.add(asteroids[0]);

        int idx = 1;
        while (idx < asteroids.length) {
            int curr = asteroids[idx];
            if (list.size() == 0) {
                list.add(curr);
                idx++;
                continue;
            }

            int prev = list.get(list.size() - 1);

            if (curr * prev > 0 || (prev < 0 && curr > 0)) {
                list.add(curr);
                idx++;
            } else {
                if (Math.abs(curr) == Math.abs(prev)) {
                    list.remove(list.size() - 1);
                    idx++;
                } else if (Math.abs(curr) < Math.abs(prev)) {
                    idx++;
                } else if (Math.abs(curr) > Math.abs(prev)) {
                    list.remove(list.size() - 1);
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
 
        return answer;
    }
}