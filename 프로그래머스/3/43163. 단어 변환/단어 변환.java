import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {

        Queue<Integer> q = new LinkedList<>(); 
        boolean[] used = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int cnt = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) != word.charAt(j)) cnt++;
            }
            if (cnt == 1) {
                q.add(i);
                used[i] = true;
            }
        }
        
        if (q.size() == 0) return 0;
        
        int answer = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int s = 0; s < size; s++) {
                int c = q.poll();
                String curr = words[c]; 

                if (curr.equals(target)) return answer;

                for (int i = 0; i < words.length; i++) {
                    if (!used[i]) {
                        String word = words[i];
                        int cnt = 0;
                        for (int j = 0; j < curr.length(); j++) {
                            if (curr.charAt(j) != word.charAt(j)) cnt++;
                        }
                        if (cnt == 1) {
                            q.add(i);
                            used[i] = true;
                        }
                    }
                }
            }
            answer++;
        }
        
        return 0;
    }
}