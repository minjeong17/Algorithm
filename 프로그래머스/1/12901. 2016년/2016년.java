import java.util.*;

class Solution {
    public String solution(int a, int b) {
        
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        Map<Integer, Integer> days = new HashMap<>();
        days.put(1, 31); days.put(2, 29); days.put(3, 31);
        days.put(4, 30); days.put(5, 31); days.put(6, 30);
        days.put(7, 31); days.put(8, 31); days.put(9, 30);
        days.put(10, 31); days.put(11, 30); days.put(12, 31);
        
        int dayCnt = b;
        for (int i = 1; i < a; i++) {
            dayCnt += days.get(i);
        }
        
        return day[dayCnt%7];
    }
}