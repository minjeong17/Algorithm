import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        int prime = 2;
        while (N > 1) {
            if (N % prime == 0) {
                sb.append(prime).append("\n");
                N /= prime;
            } else {
                prime++;
            }
        }
        
        System.out.println(sb.toString());
    }
}