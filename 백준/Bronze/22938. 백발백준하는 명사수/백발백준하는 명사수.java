import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X1 = Long.parseLong(st.nextToken());
        long Y1 = Long.parseLong(st.nextToken());
        long R1 = Long.parseLong(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        long X2 = Long.parseLong(st.nextToken());
        long Y2 = Long.parseLong(st.nextToken());
        long R2 = Long.parseLong(st.nextToken());
        
        long len1 = (X2 - X1) * (X2 - X1) + (Y2 - Y1) * (Y2 - Y1);
        long len2 = (R1 + R2) * (R1 + R2);
        
        if (len1 < len2) System.out.println("YES");
        else System.out.println("NO");
    }
}