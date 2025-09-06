import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String num1 = st.nextToken();
        String num2 = st.nextToken();
        
        long ans = 0;
        for (int i = 0; i < num1.length(); i++) {
            int curr = Integer.parseInt(num1.charAt(i)+"");
            for (int j = 0; j < num2.length(); j++) {
                int curr2 = Integer.parseInt(num2.charAt(j)+"");
                ans += curr * curr2;
            }
        }
        
        System.out.println(ans);
    }
}