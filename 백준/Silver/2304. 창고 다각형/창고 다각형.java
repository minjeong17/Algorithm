import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] containers = new int[N][2];
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if (y > maxY) {
                maxY = Math.max(y, maxY);
            } 
            containers[i][0] = x;
            containers[i][1] = y;
        }
        
        Arrays.sort(containers, (o1, o2) -> o1[0] - o2[0]);
        List<Integer> maxX = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (containers[i][1] == maxY) maxX.add(i);
        }
        
        int maxL = maxX.get(0);
        int maxR = maxX.get(maxX.size()-1);
        
        int answer = 0;
        
        int currX = containers[0][0];
        int currY = containers[0][1];
        for (int i = 0; i <= maxL; i++) {
            if (currY <= containers[i][1]) {
                answer += (containers[i][0] - currX) * currY;
                currX = containers[i][0];
                currY = containers[i][1];
            }
        }
        
        currX = containers[N-1][0];
        currY = containers[N-1][1];
        for (int i = N-1; i >= maxR; i--) {
            if (containers[i][1] >= currY) {
                answer += (currX - containers[i][0]) * currY;
                currX = containers[i][0];
                currY = containers[i][1];
            }
        }
        
        answer += (containers[maxR][0] - containers[maxL][0] + 1) * maxY;
             
        System.out.println(answer);
    }
}