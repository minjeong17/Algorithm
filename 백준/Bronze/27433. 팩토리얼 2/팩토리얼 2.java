import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long N = Long.parseLong(br.readLine());
        
        System.out.println(factorial(N));
    }
    
    public static long factorial(long N) {
        if (N <= 1) return 1;
        return N * factorial(N-1);
    }
}