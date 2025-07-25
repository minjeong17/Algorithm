import java.util.*;

class Solution {
    public int solution(int[] array) {
        
        Map<Integer, Integer> cntNum = new HashMap<>();
        for (int a : array) {
            cntNum.put(a, cntNum.getOrDefault(a, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(cntNum.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        
        if (list.size() == 1) return list.get(0).getKey();
        else {
            Map.Entry<Integer, Integer> e0 = list.get(0);
            Map.Entry<Integer, Integer> e1 = list.get(1);

            if (e0.getValue() == e1.getValue()) return -1;
            else return e0.getKey();
        }
    }
}