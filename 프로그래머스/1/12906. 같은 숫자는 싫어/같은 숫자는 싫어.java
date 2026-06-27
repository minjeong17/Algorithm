import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        List<Integer> tmpList = new ArrayList<>();
        int prev = -1;
        
        for (int a : arr) {
            if (a != prev) {
                tmpList.add(a);
                prev = a;
            }
        }
        
        int[] answer = new int[tmpList.size()];
        for (int i = 0; i < tmpList.size(); i++) {
            answer[i] = tmpList.get(i);
        }

        return answer;
    }
}