import java.util.*;

class Solution {
    public int[] sel;
    public List<int[]> list;
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        list = new ArrayList<>();
        sel = new int[5];
        comb(1, 0, n);
        
        List<Set<Integer>> qList = new ArrayList<>();
        for (int[] qq : q) {
            Set<Integer> set = new HashSet<>();
            for (int qqq : qq) {
                set.add(qqq);
            }
            
            qList.add(set);
        } 
        
                
        for (int i = 0; i < list.size(); i++) {
            int[] curr = list.get(i);
            
            boolean flag = true;
            for (int j = 0; j < q.length; j++) {
                int cnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (qList.get(j).contains(curr[k])) cnt++;
                }
                
                if (cnt != ans[j]) flag = false;
            }
            
            if (flag) answer++;
        }
        
        return answer;
    }
    
    public void comb(int idx, int sidx, int n) {
        if (sidx == 5) {
            list.add(sel.clone());
            return;
        }
        
        for (int i = idx; i <= n; i++) {
            sel[sidx] = i;
            comb(i+1, sidx+1, n);
        }
    }
}