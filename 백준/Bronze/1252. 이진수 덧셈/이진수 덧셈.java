import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger num1 = new BigInteger(st.nextToken(), 2); 
        BigInteger num2 = new BigInteger(st.nextToken(), 2);

        BigInteger sum = num1.add(num2);

        System.out.println(sum.toString(2));
    }
}
