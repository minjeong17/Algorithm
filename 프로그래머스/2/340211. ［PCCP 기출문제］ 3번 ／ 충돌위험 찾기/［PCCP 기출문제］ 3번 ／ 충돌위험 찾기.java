import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        
        Map<Integer, List<String>> position = new HashMap<>();
        
        int rob = 1;
        List<String> tmp = new ArrayList<>();
        int maxDis = Integer.MIN_VALUE;
        for (int[] route : routes) {
            int startR = points[route[0]-1][0];
            int startC = points[route[0]-1][1];
            tmp.add(startR + " " + startC);
            
            for (int i = 0; i < route.length-1; i++) {
                startR = points[route[i]-1][0];
                startC = points[route[i]-1][1];
                int endR = points[route[i+1]-1][0];
                int endC = points[route[i+1]-1][1];

                if (startR != endR) {
                    if (startR < endR) {
                        for (int r = startR+1; r <= endR; r++) {
                            tmp.add(r + " " + startC);
                        }
                    } else {
                        for (int r = startR-1; r >= endR; r--) {
                            tmp.add(r + " " + startC);
                        }  
                    }

                }
                
                if (startC != endC) {
                    if (startC < endC) {
                        for (int c = startC+1; c <= endC; c++) {
                            tmp.add(endR + " " + c);
                        }
                    } else {
                        for (int c = startC-1; c >= endC; c--) {
                            tmp.add(endR + " " + c);
                        }
                    }
                }
            }
            maxDis = Math.max(maxDis, tmp.size());
            position.put(rob++, new ArrayList<>(tmp));
            tmp.clear();
        }
        
        int answer = 0;
        int robNum = routes.length;
        for (int i = 0; i < maxDis; i++) {
            Map<String, Integer> posCount = new HashMap<>();

            for (int r = 1; r <= robNum; r++) {
                List<String> path = position.get(r);
                if (i < path.size()) {
                    String pos = path.get(i);
                    posCount.put(pos, posCount.getOrDefault(pos, 0) + 1);
                }
            }

            for (String str : posCount.keySet()) {
                if (posCount.get(str) >= 2) {
                    answer++; 
                }
            }
        }
        
        return answer;
    }
}