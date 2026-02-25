import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        int heartR = -1; int heartC = -1;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
                
                if (heartR == -1 && map[i][j] == '*') {
                    heartR = i + 1;
                    heartC = j;
                }
            }
        }
        
        int[] body = new int[5];
        // 왼쪽팔
        for (int j = heartC - 1; j >= 0; j--) {
            if (map[heartR][j] == '*') body[0]++;
            else break;
        }
        
        // 오른쪽팔
        for (int j = heartC + 1; j < N; j++) {
            if (map[heartR][j] == '*') body[1]++;
            else break;
        }
        
        // 허리
        int waistR = -1; int waistC = heartC;
        for (int i = heartR + 1; i < N; i++) {
            if (map[i][heartC] == '*') body[2]++;
            else {
                waistR = i - 1;
                break;
            }
        }
        
        // 왼쪽다리
        for (int i = waistR + 1; i < N; i++) {
            if (map[i][heartC-1] == '*') body[3]++;
            else break;
        }
        
        // 오른쪽다리
        for (int i = waistR + 1; i < N; i++) {
            if (map[i][heartC+1] == '*') body[4]++;
            else break;
        }
        
        System.out.println((heartR+1) + " " + (heartC+1));
        for (int i = 0; i < 5; i++) {
            System.out.print(body[i] + " " );
        }
    }
}