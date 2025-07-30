class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String bin = Long.toBinaryString(numbers[i]);
            long ii = 0L;
            for (int j = bin.length()-1; j >= 0; j--) {
                if (bin.charAt(j) == '0') {
                    answer[i] = numbers[i] + (long)Math.pow(2, ii);
                    if (ii >= 1) {
                        answer[i] -= (long)Math.pow(2, ii-1);
                    }
                    break;
                }
                
                if (j == 0) {
                    answer[i] = numbers[i] - (long)Math.pow(2, ii) + (long)Math.pow(2, ii+1);
                }
                
                ii++;
            }
        }
        
        
        return answer;
    }
}