class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] servers = new int[24];
        for (int i = 0; i < 24; i++) {
            int player = players[i];
            int server = servers[i];
            if (player >= (server+1) * m) {
                int tmp = server;
                while (player >= (tmp+1) * m) {
                    tmp++;
                }
                
                tmp -= server;
                answer += tmp;
                for (int j = i; j < i+k && j < 24; j++) {
                    servers[j] += tmp;
                }
            }
        }
        
        return answer;
    }
}