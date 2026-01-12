import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int ans1 = (int) (N * 0.78);
        int ans2 = (int) (N * 0.8 + N * 0.2 * 0.78);
        
        System.out.println(ans1 + " " + ans2);
    }
}