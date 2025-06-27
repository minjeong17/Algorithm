class Solution {
    public int solution(int[][] sizes) {
        
        int verti = Integer.MIN_VALUE;
        int hori = Integer.MIN_VALUE;
    
        for (int i = 0; i < sizes.length; i++) {
            verti = Math.max(verti, Math.max(sizes[i][0], sizes[i][1]));
            hori = Math.max(hori, Math.min(sizes[i][0], sizes[i][1]));
        }
        
        return verti*hori;
    }
}