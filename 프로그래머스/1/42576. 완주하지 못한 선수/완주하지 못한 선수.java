import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> comp = new HashMap<>();
        for (String name : completion) {
            comp.put(name, comp.getOrDefault(name, 0) + 1);
        }
        
        for (String name : participant) {
            if (!comp.containsKey(name)) {
                return name;
            } else {
                if (comp.get(name) - 1 == 0) comp.remove(name);
                else {
                    comp.put(name, comp.get(name) - 1);
                }
            }
        }
        
        return "";
    }
}   

        