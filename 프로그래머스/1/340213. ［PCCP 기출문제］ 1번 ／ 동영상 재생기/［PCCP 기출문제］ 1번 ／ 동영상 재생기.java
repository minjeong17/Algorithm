import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int videoLen = calTime(video_len);
        int currPos = calTime(pos);
        int opStart = calTime(op_start);
        int opEnd = calTime(op_end);
        
        for (String cmd : commands) {
            if (currPos >= opStart && currPos <= opEnd) currPos = opEnd;
            
            if (cmd.equals("prev")) {
                currPos = currPos-10 >= 0 ? currPos-10 : 0;
            } else if (cmd.equals("next")) {
                currPos = currPos+10 <= videoLen ? currPos+10 : videoLen;
            }
            
            if (currPos >= opStart && currPos <= opEnd) currPos = opEnd;
        }
        
        StringBuilder ans = new StringBuilder();
        int mm = currPos / 60;
        int ss = currPos % 60;
        
        ans.append(mm < 10 ? "0"+String.valueOf(mm) : mm)
            .append(":")
            .append(ss < 10 ? "0"+String.valueOf(ss) : ss);
        
        
        return ans.toString();
    }
    
    public int calTime(String timeStr) {
        String[] tmp = timeStr.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
}