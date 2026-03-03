import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Set<String> names = new HashSet<>();
        names.add("ChongChong");
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String n1 = st.nextToken();
            String n2 = st.nextToken();
            
            if (names.contains(n1)) {
                names.add(n2);
            } else if (names.contains(n2)) {
                names.add(n1);
            }
        }
        
        System.out.println(names.size());
    }
}