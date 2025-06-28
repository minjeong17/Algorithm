class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        
        StringBuilder side = new StringBuilder();
        for (int i = 0; i < food.length; i++) {
            if (food[i] > 1) {
                for (int j = 0; j < food[i]/2; j++) {
                    side.append(i);
                }
            }
        }
        
        answer.append(side).append(0).append(side.reverse());
        
        return answer.toString();
    }
}