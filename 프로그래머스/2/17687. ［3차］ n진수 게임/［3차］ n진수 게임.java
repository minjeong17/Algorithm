class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder ans = new StringBuilder();
        
        int num = 0, total = 0;
        outer:while (true) {
            String tmp = Integer.toString(num, n).toUpperCase();
            for (int i = 0; i < tmp.length(); i++) {
                total++;
                if (total % m == p % m) ans.append(tmp.charAt(i));
                if (ans.length() == t) break outer;
            }
            num++;
            
        }
        
        return ans.toString();
    }
}