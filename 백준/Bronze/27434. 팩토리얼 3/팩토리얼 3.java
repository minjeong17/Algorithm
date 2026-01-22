import java.io.*;
import java.math.BigInteger;

class Main {
    
    static BigInteger ans = BigInteger.ONE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        System.out.println(mul(1, N));
    }
    
    public static BigInteger mul(int start, int end) {
        if (start > end) return BigInteger.ONE;
        if (start == end) return BigInteger.valueOf(start);
        
        int mid = (start + end) / 2;
        return mul(start, mid).multiply(mul(mid + 1, end));
    }
}