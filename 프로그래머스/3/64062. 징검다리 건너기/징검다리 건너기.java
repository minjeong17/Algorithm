import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        
        TreeSet<Integer> ts = new TreeSet<>();
        for (int s : stones) ts.add(s);
        // System.out.println(ts);
        List<Integer> list = new ArrayList<>(ts);
        
        int left = 0;
        int right = ts.size()-1;
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (check(list.get(mid), k, stones)) {
                right = mid;
            } else left = mid+1;
        }
        
//         for (int t : ts) {
            
//             int cnt = 0;
//             for (int s : stones) {
//                 if (s <= t) {
//                     cnt++;
//                     if (cnt == k) return t;
//                 } else cnt = 0;
//             }
            
//         }      
        
        return list.get(left);
        
    }
    
    public boolean check(int n, int k, int[] stones) {
        // for (int t : list) {
            
        int cnt = 0;
        for (int s : stones) {
            if (s <= n) {
                cnt++;
                if (cnt == k) return true;
            } else cnt = 0;
        }
        return false;
        // } 
    }
}




// class Solution {
//     public int solution(int[] stones, int k) {
//         int answer = 0;
        

//         int min = Integer.MAX_VALUE;
//         for (int s : stones) {
//             min = Math.min(min, s);
//         }
        
//         while (true) {
//             answer += min;
            
//             int cnt0 = 0;
//             for (int i = 0; i < stones.length; i++) {
//                 if (stones[i] != 0) {
//                     stones[i] = Math.max(stones[i]-min, 0);
//                 }
                
//                 if (stones[i] == 0) {
//                     cnt0++;
//                     if (cnt0 == k) {
//                         return answer;
//                     }
//                 } else {
//                     cnt0 = 0;
//                 }
//             }
            
//             min = Integer.MAX_VALUE;
//             for (int s : stones) {
//                 if (s != 0) {
//                     min = Math.min(min, s);
//                 }
//             }
//         }
//     }
// }