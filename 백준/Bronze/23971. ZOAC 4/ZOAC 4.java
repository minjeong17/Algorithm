import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int vert = H/(N+1);
        int hori = W/(M+1);
        
        if (H % (N+1) != 0) vert++;
        if (W % (M+1) != 0) hori++;
        
        System.out.println(vert * hori);
    }
}