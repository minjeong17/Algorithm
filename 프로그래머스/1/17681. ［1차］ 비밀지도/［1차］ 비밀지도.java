class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            String tmp1 = Integer.toString(arr1[i], 2);
            String tmp2 = Integer.toString(arr2[i], 2);
            
            while (tmp1.length() < n) {
                tmp1 = "0" + tmp1;
            }
            
            while (tmp2.length() < n) {
                tmp2 = "0" + tmp2;
            }
            
            StringBuilder fin = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (tmp1.charAt(j) == '0' && tmp2.charAt(j) == '0') fin.append(" ");
                else fin.append("#");
            }
            
            answer[i] = fin.toString();
        }
        
        return answer;
    }
}

