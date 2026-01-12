import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        if (N == 1) {
            System.out.println(0);
        } else {
            if ((x == 1 && y == 1) || (x == 1 && y == N) || (x == N && y == 1) || (x == N && y == N)) {
                System.out.println(2);
            } else if (x > 1 && x < N && y > 1 && y < N) {
                System.out.println(4);
            } else {
                System.out.println(3);
            }
        }
    }
}