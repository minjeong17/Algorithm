class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int tmp = (int) Math.sqrt((4-brown) * (4-brown) - 16 * yellow);
        int x = 4 - brown > 0 ? ((-1) * (4 - brown) + tmp) / 4 : (-(4 - brown) - tmp) / 4;
        int y = yellow / x;
        
        answer[0] = Math.max(x, y)+2;
        answer[1] = Math.min(x, y)+2;
        
        return answer;
    }
}