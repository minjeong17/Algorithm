import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence;
        int maxCnt = Integer.MIN_VALUE;
        Map<Character, Integer> cntAll = new TreeMap<>();
        while ((sentence = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(sentence);

            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                int len = word.length();
                for (int i = 0; i < len; i++) {
                    cntAll.put(word.charAt(i), cntAll.getOrDefault(word.charAt(i), 0) + 1);
                    maxCnt = Math.max(maxCnt, cntAll.get(word.charAt(i)));
                }
            }

        }

        StringBuilder answer = new StringBuilder();
        for (Character ch : cntAll.keySet()) {
            if (cntAll.get(ch) == maxCnt) {
                answer.append(ch);
            }
        }

        System.out.println(answer.toString());
    }
}
