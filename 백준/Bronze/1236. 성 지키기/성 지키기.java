import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        boolean[] rows = new boolean[N];
        boolean[] cols = new boolean[M];
        
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(map[r][c] == 'X') {
                    rows[r] = true;
                    cols[c] = true;
                }
            }
        }
        int answerA = 0;

        for(boolean temp : rows){
            if(!temp) answerA++;
        }
        
	    int answerB = 0;
        for(boolean temp : cols){
            if(!temp) answerB++;
        }
        
        System.out.println(Math.max(answerA, answerB));
    }
}