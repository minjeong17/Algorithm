class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int[] sumArr = new int[3];
        
        int idx = 0;
        String numStr = "";
        for (int i = 0; i < dartResult.length(); i++) {
            char curr = dartResult.charAt(i);
            if (curr - '0' >= 0 && curr - '0' <= 10) {
                numStr += curr;
            } else {
                int num = 0;
                if (!numStr.equals("")) num = Integer.parseInt(numStr);
                if (curr == 'S') {
                    sumArr[idx] = num;
                    idx++;
                } else if (curr == 'D') {
                    sumArr[idx] = num * num;
                    idx++;
                } else if (curr == 'T') {
                    sumArr[idx] = num * num * num;
                    idx++;
                } else if (curr == '*') {
                    if (idx - 1 >= 0) sumArr[idx-1] *= 2;
                    if (idx - 2 >= 0) sumArr[idx-2] *= 2;
                } else {
                    if (idx - 1 >= 0) sumArr[idx-1] *= (-1);
                }
                numStr = "";
            }
        }
        
        for (int sum : sumArr) answer += sum;
        
        return answer;
    }
}