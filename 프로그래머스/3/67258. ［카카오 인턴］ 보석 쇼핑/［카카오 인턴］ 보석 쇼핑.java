import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> gemType = new HashSet<>();
        for (String g : gems) gemType.add(g);
        
        if (gemType.size() == 1) return new int[] {1, 1};
        
        Map<String, Integer> gemCnt = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int resLen = Integer.MAX_VALUE;
        gemCnt.put(gems[0], 1);
        while (left <= right) {
            if(left >= gems.length || right >= gems.length) break;
            
            if (gemCnt.size() == gemType.size()) { // 보석을 종류 별로 포함하고 있음
                if (right - left < resLen) {
                    resLen = right - left;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
                
                if (gemCnt.get(gems[left]) == 1) gemCnt.remove(gems[left]);
                else gemCnt.put(gems[left], gemCnt.get(gems[left])-1);
                left++;
                
                
            } else { // 보석 덜 포함
                if (right + 1 < gems.length) {
                    right++;
                    gemCnt.put(gems[right], gemCnt.getOrDefault(gems[right], 0) + 1);
                } else break;
                
            }
            
        }
        
        return answer;
    }
}