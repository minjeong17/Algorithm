class Solution {
    public int solution(int n) {
        
        StringBuilder tmp = new StringBuilder(Integer.toString(n, 3)).reverse();
        
        return Integer.parseInt(tmp.toString(), 3);
    }
}