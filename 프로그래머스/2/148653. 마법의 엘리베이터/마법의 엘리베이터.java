import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        String str = storey+"";
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.charAt(i)+"");
        }
        
        for (int i = str.length()-1; i >= 0; i--) {
            int n = arr[i];
            
            if (n == 10) {
                if (i == 0) {
                    answer++;
                } else {
                    arr[i-1]++;
                }
                
                continue;
            }
            
            if (n < 5) {
                answer += n;
            } else if (n > 5) {
                answer += 10 - n;
                
                if (i == 0) answer++;
                else arr[i-1]++;
            } else {
                if (i == 0) answer += 5;
                else {
                    if (arr[i-1] >= 5) {
                        answer += 10 - n;
                        arr[i-1]++;
                    } else {
                        answer += n;
                    }
                }
            }
        }    
        
        return answer;
    }
}