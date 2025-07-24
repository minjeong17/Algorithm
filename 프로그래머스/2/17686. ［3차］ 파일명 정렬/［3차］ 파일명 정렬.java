import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        Arrays.sort(files, (o1, o2) -> {
            String[] o11 = chkNum(o1);
            String[] o22 = chkNum(o2);
            
            int headCompare = o11[0].compareTo(o22[0]);
            if (headCompare != 0) return headCompare;

            int num1 = Integer.parseInt(o11[1]);
            int num2 = Integer.parseInt(o22[1]);
            if (num1 != num2) return num1 - num2;

            return 0;
        });
        
        return files;
    }

    public String[] chkNum(String str) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                if (number.length() == 0) head.append(ch);
                else tail.append(ch);
            } else {
                if (tail.length() == 0) number.append(ch);
                else tail.append(ch);
            }
        }
        
        return new String[] {head.toString().toLowerCase(), number.toString(), tail.toString().toLowerCase()};
    }
}