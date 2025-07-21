import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<Integer, Integer> carNum = new HashMap<>();
        Map<Integer, Integer> carTime = new HashMap<>();
        for (String record : records) {
            String[] rec = record.split(" ");
            String time = rec[0];
            int num = Integer.parseInt(rec[1]);
            
            if (rec[2].equals("IN")) {
                String[] t = time.split(":");
                int timeIn = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
                carNum.put(num, timeIn);
            } else {
                String[] t = time.split(":");
                int timeOut = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
                
                int totalT = timeOut - carNum.get(num);
                carTime.put(num, carTime.getOrDefault(num, 0)+totalT);
                carNum.remove(num);
            }
        }
        
        int endTime = 23 * 60 + 59;
        for (int cNum : carNum.keySet()) {
            int totalT = endTime - carNum.get(cNum);
            carTime.put(cNum, carTime.getOrDefault(cNum, 0) + totalT);
        }

        TreeMap<Integer, Integer> carPay = new TreeMap<>();
        for (int cNum : carTime.keySet()) {
            int pay = fees[1];
            int totalT = carTime.get(cNum);
            if (totalT > fees[0]) {
                pay += Math.ceil((totalT - fees[0])/(double)fees[2]) * fees[3];
            } 
            carPay.put(cNum, pay);
        }
        
        int[] answer = new int[carPay.size()];
        int idx = 0;
        for (int cNum : carPay.keySet()) {
            answer[idx++] = carPay.get(cNum);
        }
        
        return answer;
    }
}