import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Queue<String> card1Q = new LinkedList<>();
        for (String str : cards1) card1Q.add(str);
        
        Queue<String> card2Q = new LinkedList<>();
        for (String str : cards2) card2Q.add(str);
        
        for (String g : goal) {
            if (!g.equals(card1Q.peek()) && !g.equals(card2Q.peek())) return "No";
            else {
                if (g.equals(card1Q.peek())) card1Q.poll();
                else if (g.equals(card2Q.peek())) card2Q.poll();
            }
        }
        
        return "Yes";
    }
}