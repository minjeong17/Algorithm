class Solution {
    boolean solution(String s) {
        
        int pCnt = 0, yCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'p' || ch == 'P') pCnt++;
            if (ch == 'y' || ch == 'Y') yCnt++;
        }

        return pCnt == yCnt ? true : false;
    }
}