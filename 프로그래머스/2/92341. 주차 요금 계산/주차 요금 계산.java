import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> inOut = new HashMap<>();
        Map<String, Integer> totalTime = new TreeMap<>();
        for (String record : records) {
            String[] r = record.split(" ");
            String carNum = r[1];
            String[] t = r[0].split(":");
            int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            
            if (r[2].equals("IN")) {
                inOut.put(carNum, time);
            } else {
                int inTime = inOut.get(carNum);
                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + (time - inTime));
                
                inOut.remove(carNum);
            }
        }
        
        if (inOut.size() > 0) {
            for (String carNum : inOut.keySet()) {
                int inTime = inOut.get(carNum);
                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + ((23*60+59) - inTime));
            }
        }
        
        int[] answer = new int[totalTime.size()];
        int idx = 0;
        for (String carNum : totalTime.keySet()) {
            int tmp = (int)Math.ceil((totalTime.get(carNum) - fees[0]) / (double)fees[2]);
            
            if (tmp >= 0) answer[idx++] = fees[1] + tmp * fees[3];
            else answer[idx++] = fees[1];
        }

        return answer;
    }
}