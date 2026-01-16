import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int X = Integer.parseInt(br.readLine());
        
        int k = 0;
        int sum = 0;
        while (true) {
            sum += ++k;
            if (sum >= X) {
                break;
            }
        }
        
        int n1 = 0;
        int n2 = 0;
        if (k % 2 == 0) {
            n1 = k - (sum - X);
            n2 = 1 + (sum - X);
        } else {
            n1 = 1 + (sum - X);
            n2 = k - (sum - X);
        }
        
        System.out.println(n1 + "/" + n2);        
    }
}