import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> symbol = new HashMap<>();
        symbol.put('I', 1); symbol.put('V', 5); symbol.put('X', 10);
        symbol.put('L', 50); symbol.put('C', 100); symbol.put('D', 500); symbol.put('M', 1000);
        Map<String, Integer> subMap = new HashMap<>();
        subMap.put("IV", 4); subMap.put("IX", 9);
        subMap.put("XL", 40); subMap.put("XC", 90);
        subMap.put("CD", 400); subMap.put("CM", 900);

        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && subMap.containsKey(s.substring(i, i + 2))) {
                answer += subMap.get(s.substring(i, i + 2));
                i++;
            } else {
                answer += symbol.get(s.charAt(i));
            }
        }

        return answer;
    }
}