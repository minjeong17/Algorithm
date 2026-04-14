import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] S = br.readLine().toCharArray();
        int len = S.length;
        
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < len; i++) {
            if (S[i] == '0') cnt0++;
            else if (S[i] == '1') cnt1++;
        }
        
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (S[i] == '1') {
                S[i] = '-';
                cnt++;
            }
            if (cnt == cnt1/2) break;
        }
        
        cnt = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (S[i] == '0') {
                S[i] = '-';
                cnt++;
            }
            if (cnt == cnt0/2) break;
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (S[i] != '-') ans.append(S[i]);
        }
        
        System.out.println(ans.toString());
    }
} 