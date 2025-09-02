import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = Integer.MIN_VALUE;
        
        PriorityQueue<int[]> times = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        for (String[] book : book_time) {
            String[] start = book[0].split(":");
            String[] end = book[1].split(":");
            
            int[] tmp = new int[2];
            tmp[0] = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            tmp[1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            
            times.add(tmp);
        }
        
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        while (!times.isEmpty()) {
            int[] curr = times.poll();
            
            while (!endTimes.isEmpty() && endTimes.peek() <= curr[0]) {
                endTimes.poll();
            }
            endTimes.add(curr[1]+10);
            answer = Math.max(answer, endTimes.size());
        } 
        
        return answer;
    }
}