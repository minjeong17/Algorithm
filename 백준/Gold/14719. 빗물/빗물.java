import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        boolean[][] blocks = new boolean[H][W];
        for (int i = 0; i < W; i++) {
            int height = Integer.parseInt(st.nextToken());
            for (int j = 0; j < height; j++) {
                blocks[H-j-1][i] = true;
            }
        }
                
        int answer = 0;
        for (int i = 0; i < H; i++) {
            int left = -1;
            for (int j = 0; j < W; j++) {
                if (blocks[i][j]) {
                    if (left != -1) {
                        answer += j - left - 1;
                    } 
                    left = j;
                }
            }
        }
        
        System.out.println(answer);
    }
}