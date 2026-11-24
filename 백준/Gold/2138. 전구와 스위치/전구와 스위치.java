import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        String str = br.readLine();
        int[] curr1 = new int[N];
        int[] curr2 = new int[N];
        for (int i = 0; i < N; i++) {
            curr1[i] = str.charAt(i) - '0';
            curr2[i] = str.charAt(i) - '0';
        }
        
        str = br.readLine();
        int[] target = new int[N];
        for (int i = 0; i < N; i++) {
            target[i] = str.charAt(i) - '0';
        }
        
        int answer = Integer.MAX_VALUE;
        
        // 0번 누름
        curr1[0] = (curr1[0] + 1) % 2;
        curr1[1] = (curr1[1] + 1) % 2;
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (curr1[i-1] != target[i-1]) {
                cnt++;
                if (i == N-1) {
                    curr1[i-1] = (curr1[i-1] + 1) % 2;
                    curr1[i] = (curr1[i] + 1) % 2;
                } else {
                    curr1[i-1] = (curr1[i-1] + 1) % 2;
                    curr1[i] = (curr1[i] + 1) % 2;
                    curr1[i+1] = (curr1[i+1] + 1) % 2;
                }
            }
        }
        
        boolean check = true;
        for (int i = 0; i < N; i++) {
            if (curr1[i] != target[i]) {
                check = false;
                break;
            }
        }
        
        if (check) answer = Math.min(answer, cnt);
        
        cnt = 0;
        for (int i = 1; i < N; i++) {
            if (curr2[i-1] != target[i-1]) {
                cnt++;
                if (i == N-1) {
                    curr2[i-1] = (curr2[i-1] + 1) % 2;
                    curr2[i] = (curr2[i] + 1) % 2;
                } else {
                    curr2[i-1] = (curr2[i-1] + 1) % 2;
                    curr2[i] = (curr2[i] + 1) % 2;
                    curr2[i+1] = (curr2[i+1] + 1) % 2;
                }
            }
        }
        
        check = true;
        for (int i = 0; i < N; i++) {
            if (curr2[i] != target[i]) {
                check = false;
                break;
            }
        }
        
        if (check) answer = Math.min(answer, cnt);
        
        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
}