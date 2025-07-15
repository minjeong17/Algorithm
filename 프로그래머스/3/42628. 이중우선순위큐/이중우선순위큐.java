import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        for (String op : operations) {
            if (op.charAt(0) == 'D') {
                if (tm.isEmpty()) continue;
                
                if (op.length() == 3) {
                    int max = tm.lastKey();
                    if (tm.get(max) == 1) tm.remove(max);
                    else {
                        tm.put(max, tm.get(max)-1);
                    }
                } else {
                    int min = tm.firstKey();
                    if (tm.get(min) == 1) tm.remove(min);
                    else {
                        tm.put(min, tm.get(min)-1);
                    }
                }
            } else {
                int n = Integer.parseInt(op.split(" ")[1]);
                tm.put(n, tm.getOrDefault(n, 0) + 1);
            }
        }
        
        if (tm.size() == 0) return new int[] {0, 0};
        else return new int[] {tm.lastKey(), tm.firstKey()};
        
    }
}