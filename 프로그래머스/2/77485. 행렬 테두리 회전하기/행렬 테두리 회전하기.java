import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] nums = new int[rows][columns];
        int n = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                nums[i][j] = n++;
            }
        }                
        
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            
            int tmp = -1;
            int minN = Integer.MAX_VALUE;
            for (int j = query[1]-1; j < query[3]; j++) {
                if (tmp == -1) {
                    tmp = nums[query[0]-1][j];
                } else {
                    int t = nums[query[0]-1][j];
                    nums[query[0]-1][j] = tmp;
                    tmp = t;
                }
                
                minN = Math.min(minN, tmp);
            }
                        
            for (int j = query[0]; j < query[2]; j++) {
                int t = nums[j][query[3]-1];
                nums[j][query[3]-1] = tmp;
                tmp = t;
                
                minN = Math.min(minN, tmp);
            }
            
            for (int j = query[3]-2; j >= query[1]-1; j--) {
                int t = nums[query[2]-1][j]; 
                nums[query[2]-1][j] = tmp;
                tmp = t;
                
                minN = Math.min(minN, tmp);
            }
            
            for (int j = query[2]-2; j >= query[0]-1; j--) {
                int t = nums[j][query[1]-1];
                nums[j][query[1]-1] = tmp;
                tmp = t;
                
                minN = Math.min(minN, tmp);
            }
            
            answer[i] = minN;  
        }
        
        return answer;
    }
}