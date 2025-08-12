import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine();
	    int F = Integer.parseInt(br.readLine());
        
        String tmp = N.substring(0, N.length()-2);
        
        int ans = -1;
        for (int i = 0; i < 100; i++) {
            int nn;
            if (i < 10) {
                nn = Integer.parseInt(tmp + "0" + (i+""));
            } else {
                nn = Integer.parseInt(tmp + (i+""));
            }
            
            if (nn % F == 0) {
                ans = i;
                break;
            }
        }
        
        if (ans < 10) System.out.println("0"+ans+"");
        else System.out.println(ans);
    }
}