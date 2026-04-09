import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String loc = br.readLine();
        int len = loc.length();
        boolean[] leftH = new boolean[loc.length()];
        for (int i = 0; i < len; i++) {
            if (loc.charAt(i) == 'H') {
                leftH[i] = true;
            } 
        }

        int answer = 0;
        for (int i = 0; i < loc.length(); i++) {
            if (loc.charAt(i) == 'P') {
                for (int j = Math.max(0, i - K); j <= Math.min(len-1, i + K); j++) {
                    if (leftH[j]) {
                        leftH[j] = false;
                        answer++;
                        break;
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}