import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        Queue<Integer> s1 = new LinkedList<>();
        s1.add(1); s1.add(2); s1.add(3); s1.add(4); s1.add(5);
        Queue<Integer> s2 = new LinkedList<>();
        s2.add(2); s2.add(1); s2.add(2); s2.add(3); s2.add(2); s2.add(4); s2.add(2); s2.add(5); 
        Queue<Integer> s3 = new LinkedList<>();
        s3.add(3); s3.add(3); s3.add(1); s3.add(1); s3.add(2); s3.add(2); s3.add(4); s3.add(4); s3.add(5); s3.add(5); 
        
        int sc1 = 0;
        int sc2 = 0;
        int sc3 = 0;
        for (int a : answers) {
            int ss1 = s1.poll();
            int ss2 = s2.poll();
            int ss3 = s3.poll();
            
            if (ss1 == a) sc1++;
            if (ss2 == a) sc2++;
            if (ss3 == a) sc3++;
            
            s1.add(ss1);
            s2.add(ss2);
            s3.add(ss3);
        }
        
        int maxSc = Math.max(sc1, Math.max(sc2, sc3));
        List<Integer> ansList = new ArrayList<>();
        if (maxSc == sc1) ansList.add(1);
        if (maxSc == sc2) ansList.add(2);
        if (maxSc == sc3) ansList.add(3);
        
        int[] answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        
        return answer;
    }
}