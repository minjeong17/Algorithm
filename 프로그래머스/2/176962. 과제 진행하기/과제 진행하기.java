import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        }); // [인덱스, 시작시간, 소요시간]
        
        int minStart = Integer.MAX_VALUE;
        for (int i = 0; i < plans.length; i++) {
            String[] start = plans[i][1].split(":");
            int time = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            minStart = Math.min(minStart, time);
            
            pq.add(new int[] {i, time, Integer.parseInt(plans[i][2])});
        }
        
        int time = minStart;
        int idx = 0;
        int[] curr = new int[3];
        Arrays.fill(curr, -1);
        Stack<int[]> stack = new Stack<>();
        while (idx < plans.length) {
            if (!pq.isEmpty() && time == pq.peek()[1]) { // 시작해야 하는 과제 있음
                int[] t = pq.poll();
                if (curr[0] > -1) { // 진행 중인 과제 없음
                    stack.push(curr.clone());  // 진행 중인 과제 멈춤
                } 
                for (int i = 0; i < 3; i++) curr[i] = t[i]; // 과제 시작
            } else { // 시작해야 하는 과제 없음
                if (curr[0] == -1 && !stack.isEmpty()) { // 하고 있는 과제 없음 + 멈췄던 과제 있음
                    int[] t = stack.pop();
                    for (int i = 0; i < 3; i++) curr[i] = t[i]; // 과제 시작
                }
                
            }
            
            if (curr[0] > -1) curr[2]--;
            if (curr[2] == 0) {
                answer[idx] = plans[curr[0]][0];
                Arrays.fill(curr, -1);
                idx++;
            }
            time++;
        }
        
        return answer;
    }
}