import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] coord = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            coord[i][0] = Integer.parseInt(st.nextToken());
            coord[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(coord, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        int answer = 0;
        int[] curr = coord[0];
        for (int i = 1; i < N; i++) {
            int[] c = coord[i];

            if (curr[1] >= c[1]) continue;            
            else if (curr[1] >= c[0]) {
                curr[1] = c[1];
            } else {
                answer += curr[1] - curr[0];
                curr[0] = c[0];
                curr[1] = c[1];
            }
        }
        
        answer += curr[1] - curr[0];
        
        System.out.println(answer);
    }
}