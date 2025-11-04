import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        
        String answer = "(None)";
        int maxTime = Integer.MIN_VALUE;
        
        for (String music : musicinfos) {
            String[] infos = music.split(",");
            
            String[] startTime = infos[0].split(":");
            String[] endTime = infos[1].split(":");
            
            int time = (Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1])) 
                            - (Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]));
            
            String tt = infos[3].replace("#", "");
            int len = tt.length();
            StringBuilder total = new StringBuilder();
            for (int i = 0; i < time/len; i++) {
                total.append(infos[3]);
            }
            int idx = 0;
            for (int i = 0; i < time%len; i++) {
                total.append(infos[3].charAt(idx)+"");
                idx++;
                if (infos[3].charAt(idx) == '#') {
                    total.append("#");
                    idx++;
                }
            }
            
            if (check(m, total.toString())) {
                if (maxTime < time) {
                    answer = infos[2];
                    maxTime = time;
                }
            }            
        }
        
        return answer;
    }
    
    public boolean check(String m, String total) {
        m = m.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#", "a");
        total = total.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#", "a");
        
        if (total.contains(m)) return true;
        return false;
    }
}