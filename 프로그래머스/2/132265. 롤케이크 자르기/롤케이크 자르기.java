import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> rightCnt = new HashMap<>();
        for (int t : topping) rightCnt.put(t, rightCnt.getOrDefault(t, 0) + 1);
        
        Set<Integer> left = new HashSet<>();
        for (int t : topping) {
            left.add(t);
            rightCnt.put(t, rightCnt.get(t) - 1);
            if (rightCnt.get(t) == 0) rightCnt.remove(t);
            
            if (left.size() == rightCnt.size()) answer++;
        }
        
        return answer;
    }
}