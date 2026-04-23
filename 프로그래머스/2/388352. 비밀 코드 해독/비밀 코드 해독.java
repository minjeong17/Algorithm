import java.util.*;

class Solution {
    public int answer;
    public int[] info, sel;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        
        info = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int tmp = 0;
            for (int qq : q[i]) {
                tmp |= (1 << qq);
            }
            info[i] = tmp;
        }
        
        sel = new int[5];
        comb(1, 0, n, ans);
        
        return answer;
    }
    
    public void comb(int idx, int sidx, int n, int[] ans) {
        if (sidx == 5) {
            int selBit = 0;
            for (int s : sel) {
                selBit |= (1 << s);
            }
            
            boolean flag = true;
            for (int i = 0; i < ans.length; i++) {
                if (Integer.bitCount(info[i] & selBit) != ans[i]) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer++;
            return;
        }
        
        for (int i = idx; i <= n; i++) {
            sel[sidx] = i;
            comb(i+1, sidx+1, n, ans);
        }
    }
}


// 조합 + 완잔탐색
// class Solution {
//     public int[] sel;
//     public List<int[]> list;
//     public int solution(int n, int[][] q, int[] ans) {
//         int answer = 0;
        
//         list = new ArrayList<>();
//         sel = new int[5];
//         comb(1, 0, n);
        
//         List<Set<Integer>> qList = new ArrayList<>();
//         for (int[] qq : q) {
//             Set<Integer> set = new HashSet<>();
//             for (int qqq : qq) {
//                 set.add(qqq);
//             }
            
//             qList.add(set);
//         } 
        
                
//         for (int i = 0; i < list.size(); i++) {
//             int[] curr = list.get(i);
            
//             boolean flag = true;
//             for (int j = 0; j < q.length; j++) {
//                 int cnt = 0;
//                 for (int k = 0; k < 5; k++) {
//                     if (qList.get(j).contains(curr[k])) cnt++;
//                 }
                
//                 if (cnt != ans[j]) flag = false;
//             }
            
//             if (flag) answer++;
//         }
        
//         return answer;
//     }
    
//     public void comb(int idx, int sidx, int n) {
//         if (sidx == 5) {
//             list.add(sel.clone());
//             return;
//         }
        
//         for (int i = idx; i <= n; i++) {
//             sel[sidx] = i;
//             comb(i+1, sidx+1, n);
//         }
//     }
// }