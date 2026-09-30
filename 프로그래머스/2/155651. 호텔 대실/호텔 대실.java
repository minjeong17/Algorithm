import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] book_time_parsed = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            book_time_parsed[i][0] = parsingTime(book_time[i][0]);
            book_time_parsed[i][1] = parsingTime(book_time[i][1]);
        }
        Arrays.sort(book_time_parsed, (o1, o2) -> {
            return o1[0] - o2[0];
        });
         
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] bk : book_time_parsed) {     
            if (!pq.isEmpty() && pq.peek() <= bk[0]) {
                pq.poll();
                pq.add(bk[1] + 10);
            } else {
                pq.add(bk[1] + 10);
                answer++;
            }
        }
        
        return answer;
    }
    
    public int parsingTime(String time) {
        String[] tmp = time.split(":");
        
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
}