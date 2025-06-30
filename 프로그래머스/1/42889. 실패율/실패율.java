import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] reached = new int[N+2];
        int[] stuck = new int[N+2];
        for (int s : stages) {
            for (int i = 1; i <= s; i++) reached[i]++;
            stuck[s]++;
        }
        
        double[] fail = new double[N+1];
        for (int i = 1; i <= N; i++) {
            fail[i] = reached[i] == 0 ? 0.0 : ((double) stuck[i]) / reached[i];
        }
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (Double.compare(o1[1], o2[1]) == 0) return Double.compare(o1[0], o2[0]);
            return Double.compare(o2[1], o1[1]);
        });
        
        for (int i = 1; i <= N; i++) {
            pq.add(new double[] {i, fail[i]});
        }

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) (pq.poll()[0]);
        }
        
        return answer;
    }
}