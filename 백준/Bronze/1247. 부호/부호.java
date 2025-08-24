import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int ii = 0; ii < 3; ii++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = BigInteger.ZERO;
            for (int i = 0; i < N; i++) {
                String tmp = br.readLine();
                sum = sum.add(new BigInteger(tmp));
            }

            if (sum.signum() == 0) sb.append("0\n");
            else if (sum.signum() > 0) sb.append("+\n");
            else sb.append("-\n");
        }
        
        System.out.println(sb.toString());
    }
}