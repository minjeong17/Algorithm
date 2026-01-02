import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger num = new BigInteger(br.readLine(), 2);
        System.out.println(num.toString(8));
    }
}
