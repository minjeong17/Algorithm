import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int answer = 0;
        Set<String> names = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            if ("ENTER".equals(name)) {
                answer += names.size();
                names.clear();
            } else {
                names.add(name);
            }
        }
        answer += names.size();
        
        System.out.println(answer);
    }
}