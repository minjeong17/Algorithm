import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        
        Set<String> names = new HashSet<>();
        for (int i = 0; i < N; i++) {
            names.add(br.readLine());
        }
        
        if (game.equals("Y")) {
            System.out.println(names.size());
        } else if (game.equals("F")) {
            System.out.println(names.size()/2);
        } else {
            System.out.println(names.size()/3);
        }
    }
}