import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String word = br.readLine();
        
        int[] cnt = new int[26];
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toUpperCase(word.charAt(i));
            
            cnt[ch-'A']++;
            maxCnt = Math.max(maxCnt, cnt[ch-'A']);
        }
        
        char answer = '?';
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == maxCnt) {
                if (answer != '?') {
                    answer = '?';
                    break;
                } else {
                    answer = (char)(i+65);
                }
            }
        }
        
        System.out.println(answer);
    }
}