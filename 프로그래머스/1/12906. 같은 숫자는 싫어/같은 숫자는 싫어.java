import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] != arr[i]) tmpList.add(arr[i]);
        }
        
        int[] answer = new int[tmpList.size()];
        for (int i = 0; i < tmpList.size(); i++) {
            answer[i] = tmpList.get(i);
        }

        return answer;
    }
}