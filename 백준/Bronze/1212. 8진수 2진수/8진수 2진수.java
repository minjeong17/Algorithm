import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        StringBuilder sb = new StringBuilder();

        sb.append(Integer.toBinaryString(N.charAt(0) - '0'));

        for (int i = 1; i < N.length(); i++) {
            String tmp = Integer.toBinaryString(N.charAt(i) - '0');
            for (int ii = 0; ii < 3-tmp.length(); ii++) {
                sb.append(0);
            }
            sb.append(tmp);
        }

        System.out.println(sb.toString());
    }
}
