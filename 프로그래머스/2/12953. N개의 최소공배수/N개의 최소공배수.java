class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            int gcd = 0;
            for (int j = Math.min(arr[i], answer); j > 0; j--) {
                if (arr[i] % j == 0 && answer % j == 0) {
                    gcd = j;
                    break;
                }
            }
            answer = gcd * (arr[i] / gcd) * (answer / gcd);
        }
        
        return answer;
    }
}