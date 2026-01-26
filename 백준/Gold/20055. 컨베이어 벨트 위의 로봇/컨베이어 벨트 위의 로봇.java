import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int robotNum = N * 2;
        
        int hp0 = 0;
        int[] belt = new int[robotNum];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N*2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
            if (belt[i] == 0) hp0++;
        }
        
        int answer = 0;
        int up = 0;
        int down = N-1;
        boolean[] robotExist = new boolean[robotNum];
        while (true) {
            answer++;
            up = (up - 1 + robotNum) % robotNum;  // 1. 회전한다
            down = (up + N - 1) % (robotNum);
            robotExist[down] = false;
            for (int i = N - 2; i >= 0; i--) {
                int curr = (i + up) % robotNum;
                int next = (curr + 1) % robotNum;
                
                if (robotExist[curr] && !robotExist[next] && belt[next] > 0) {
                    robotExist[curr] = false;
                    robotExist[next] = true;
                    belt[next]--;
                    if (belt[next] == 0) hp0++;
                }
            }
            
            robotExist[down] = false;
            
            if (!robotExist[up] && belt[up] != 0) {  // 3. 로봇 올린다
                robotExist[up] = true;
                belt[up]--;
                if (belt[up] == 0) hp0++;
            }
            
            if (hp0 >= K) break;  // 4. 과정 종료한다
        }
        
        System.out.println(answer);
    }
}