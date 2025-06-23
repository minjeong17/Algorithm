import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        int[][] dp = new int[word1.length()+1][word2.length()+1];
        int maxLen = Integer.MIN_VALUE;
        for (int j = 1; j <= word2.length(); j++) {
            char word2Char = word2.charAt(j-1);
            for (int i = 1; i <= word1.length(); i++) {
                char word1Char = word1.charAt(i-1);
                if (word1Char == word2Char) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        System.out.println(maxLen);
    }
}
