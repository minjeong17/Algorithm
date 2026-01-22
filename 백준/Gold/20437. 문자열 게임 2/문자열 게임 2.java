import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int t = 0; t < T; t++) {
            char[] W = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());
            
            List<Integer>[] chIdx = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                chIdx[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < W.length; i++) {
                chIdx[W[i]-'a'].add(i);
            }
                        
            int len1 = Integer.MAX_VALUE;
            int len2 = Integer.MIN_VALUE;
            for (int i = 0; i < 26; i++) {
                if (chIdx[i].size() >= K) {
                    for (int j = 0; j <= chIdx[i].size()-K; j++) {
                        len1 = Math.min(len1, chIdx[i].get(j + K - 1) - chIdx[i].get(j) + 1);
                        len2 = Math.max(len2, chIdx[i].get(j + K - 1) - chIdx[i].get(j) + 1);
                    }
                }
            }
            
            if (len1 == Integer.MAX_VALUE) {
                ans.append(-1);
            } else {
                ans.append(len1).append(" ").append(len2);
            }
            
            if (t < T-1) ans.append("\n");
        }
        
        System.out.println(ans.toString());
    }
}