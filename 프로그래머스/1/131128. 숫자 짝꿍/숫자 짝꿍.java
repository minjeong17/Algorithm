import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        Map<Character, Integer> numCnt = new HashMap<>();
        for (int i = 0; i < X.length(); i++) {
            char curr = X.charAt(i);
            numCnt.put(curr, numCnt.getOrDefault(curr, 0) + 1);
        }
        
        PriorityQueue<Character> commonNums = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 0; i < Y.length(); i++) {
            char curr = Y.charAt(i);
            if (numCnt.containsKey(curr)) {
                commonNums.add(curr);
                if (numCnt.get(curr) == 1) numCnt.remove(curr);
                else numCnt.put(curr, numCnt.get(curr)-1);
            }
        }

        StringBuilder ans = new StringBuilder();
        int size = commonNums.size();
        for (int i = 0; i < size; i++) {
            ans.append(commonNums.poll());
        }
        
        if ("".equals(ans.toString())) return "-1";
        else if (ans.toString().replaceAll("0", "").length() == 0) return "0";
        else return ans.toString();
    }   
}