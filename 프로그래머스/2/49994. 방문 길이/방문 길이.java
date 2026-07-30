import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        Map<Character, Integer> dirMap = new HashMap<>();
        dirMap.put('U', 0); dirMap.put('D', 1); dirMap.put('R', 2); dirMap.put('L', 3);
        
        Set<String> visited = new HashSet<>();
        int startR = 0; int startC = 0;
        StringBuilder move = new StringBuilder();
        StringBuilder moveRev = new StringBuilder();
        for (char c : dirs.toCharArray()) {
            int d = dirMap.get(c);
            int endR = startR + dr[d];
            int endC = startC + dc[d];
            
            if (endR < -5 || endR > 5 || endC < -5 || endC > 5) continue;
            
            move.append(startR).append(startC).append(endR).append(endC);
            moveRev.append(endR).append(endC).append(startR).append(startC);
            String tmp1 = move.toString();
            String tmp2 = moveRev.toString();
            if (!visited.contains(tmp1) && !visited.contains(tmp2)) {
                answer++;
                visited.add(tmp1);  
                visited.add(tmp2);  
            }
            
            startR = endR;
            startC = endC;
            move.setLength(0);
            moveRev.setLength(0);
        }
        
        
        return answer;
    }
}