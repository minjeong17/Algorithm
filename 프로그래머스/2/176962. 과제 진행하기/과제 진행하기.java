import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));
        // System.out.println(Arrays.deepToString(plans));
        
        Stack<int[]> stop = new Stack<>(); // [인덱스, 걸리는 시간, 시작 시간]
        int[] curr = new int[3]; // [인덱스, 걸리는 시간, 시작 시간]
        curr[0] = -1;
        curr[1] = 1500;

        int idx = 0;
        for (int i = 0; i < plans.length; i++) {
            String[] plan = plans[i];
            
            int startT = parsingTime(plan[1]);
            
            if (curr[1] + curr[2] == startT) {
                answer[idx++] = plans[curr[0]][0];
                curr[0] = -1;
            } else if (curr[1] + curr[2] < startT) {
                answer[idx++] = plans[curr[0]][0];
                curr[0] = -1;
                
                int gap = startT - (curr[1] + curr[2]);
                
                while (gap > 0) {
                    if (!stop.isEmpty()) {
                        if (stop.peek()[1] <= gap) {
                            int[] tmp = stop.pop();
                            answer[idx++] = plans[tmp[0]][0];
                            
                            gap -= tmp[1];
                        } else {
                            int[] tmp = stop.pop();
                            
                            stop.push(new int[] {tmp[0], tmp[1] - gap, tmp[2]});
                            break;
                        }
                    } else break;
                }
            }
            
            if (curr[0] != -1) {
                int done = startT - curr[2];
                stop.push(new int[] {curr[0], curr[1] - done, startT});
            }
            
            curr[0] = i;
            curr[1] = Integer.parseInt(plan[2]);
            curr[2] = startT;
        }
        
        answer[idx++] = plans[curr[0]][0];
        
        while (!stop.isEmpty()) {
            int[] tmp = stop.pop();
            answer[idx++] = plans[tmp[0]][0];
        }
        
        return answer;
    }
    
    public int parsingTime(String time) {
        String[] t = time.split(":");
        
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}