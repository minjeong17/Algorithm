import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new TreeSet<>();
        
        for(String str : gems){
            set.add(str);
        }
        
        Map<String, Integer> map = new HashMap<>();
        map.put(gems[0], 1);
        int left = 0;
        int right = 0;
        while(left < gems.length){
            if(map.size() < set.size()){
                right++;
                if (right == gems.length) break;
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            } else {
                if(answer[1] == 0 && answer[0] == 0) {
                    answer[1] = right+1;
                    answer[0] = left+1;
                }
                if(right - left < answer[1] - answer[0]) {
                    answer[1] = right+1;
                    answer[0] = left+1;
                }
                if(map.get(gems[left]) == 1) map.remove(gems[left]);
                else {
                    map.put(gems[left], map.getOrDefault(gems[left], 0) - 1);
                }
                left++;
            }
        }
        
        
        return answer;
    }
}