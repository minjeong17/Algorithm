import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());
        
        int[][] cnt = new int[str.length()+1][26];
        for (int i = 1; i < str.length()+1; i++) {
            char ch = str.charAt(i-1);
            cnt[i][ch-'a'] = 1;
            for (int j = 0; j < 26; j++) {
                cnt[i][j] += cnt[i-1][j];
            }
        }
        
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = st.nextToken().charAt(0) -'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            answer.append(cnt[r+1][s] - cnt[l][s]).append("\n");
        }
        
        System.out.println(answer.toString());
    }
}