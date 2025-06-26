import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> tmp = new ArrayList<>();
        
        for (int n : arr) {
            if (n % divisor == 0) tmp.add(n);
        }
        
        int[] answer = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer.length == 0 ? new int[] {-1} : answer;
    }
}