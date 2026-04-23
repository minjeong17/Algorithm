class Solution {
    public long solution(int w, int h) {
        int a = w;
        int b = h;
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        
        long total = (long)w * h;
        
        return total - (w + h - a);
    }
}