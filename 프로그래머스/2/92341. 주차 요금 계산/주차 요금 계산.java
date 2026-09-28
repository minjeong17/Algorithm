import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {        
        Map<String, Integer> enterTime = new HashMap<>();
        Map<String, Integer> carTime = new TreeMap<>();
        for (String r : records) {
            String[] parsed = r.split(" ");
            int time = timeParsing(parsed[0]);
            
            if (parsed[2].equals("IN")) {
                enterTime.put(parsed[1], time);
            } else {
                int t = enterTime.get(parsed[1]);
                
                carTime.put(parsed[1], carTime.getOrDefault(parsed[1], 0) + (time - t));
                enterTime.remove(parsed[1]);
            }
        }
        
        for (String car : enterTime.keySet()) {
            int t = enterTime.get(car);
            
            carTime.put(car, carTime.getOrDefault(car, 0) + (1439 - t));
        }
                
        int[] answer = new int[carTime.size()];
        int idx = 0;
        for (String car : carTime.keySet()) {
            int total = carTime.get(car);
            
            if (total <= fees[0]) answer[idx++] = fees[1];
            else {
                answer[idx++] = fees[1] + (int) Math.ceil((total - fees[0]) / (double)fees[2]) * fees[3];
            }
        }
        
        return answer;
    }
    
    public int timeParsing(String time) {
        String[] t = time.split(":");
        
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}