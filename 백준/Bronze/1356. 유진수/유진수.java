import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numStr = br.readLine();
        int len = numStr.length();

        String answer = "NO";
        if (len > 1) {
            int[] numArr = new int[len];
            for (int i = 0; i < len; i++) {
                numArr[i] = numStr.charAt(i) - '0';
            }
            for (int i = 0; i < len-1; i++) {
                int mul1 = 1;
                int mul2 = 1;

                for (int j = 0; j <= i; j++) {
                    mul1 *= numArr[j];
                }
                for (int j = i+1; j < len; j++) {
                    mul2 *= numArr[j];
                }

                if (mul1 == mul2) {
                    answer = "YES";
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
