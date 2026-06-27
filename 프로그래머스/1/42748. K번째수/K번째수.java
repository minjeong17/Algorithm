import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
                
        for (int c = 0; c < commands.length; c++) {
            int[] com = commands[c];
            int i = com[0];
            int j = com[1];
            int k = com[2];
            
            List<Integer> tmp = new ArrayList<>(list.subList(i-1, j));
            Collections.sort(tmp);
            answer[c] = tmp.get(k-1);
        }        
        
        return answer;
    }
}