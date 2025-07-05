class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int[] lastArr = new int[w];
        int lastRIdx = (n / w) == ((double) n / w) ? n / w : (n / w) + 1;
        int lastCIdx = -1;
        if (lastRIdx % 2 == 0) {
            lastCIdx = w * lastRIdx - n;
            for (int i = lastCIdx; i < w; i++) {
                lastArr[i] = 1;
            }
        } else {
            lastCIdx = w - (w * lastRIdx - n) - 1;
            for (int i = 0; i <= lastCIdx; i++) {
                lastArr[i] = 1;
            }
        }
        
        int numR = (num / w) == ((double) num / w) ? num / w : (num / w) + 1;
        int numC = -1;
        if (numR % 2 == 0) {
            numC = w * numR - num;
        } else {
            numC = w - (w * numR - num) - 1;
        }
        
        if (lastArr[numC] == 1) answer = lastRIdx - numR + 1;
        else answer = lastRIdx - numR;
        
        return answer;
    }
}