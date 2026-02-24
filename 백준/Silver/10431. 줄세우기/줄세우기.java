import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int P = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int tc = 0; tc < P; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            ans.append(T).append(" ");
            
            LinkedList<Integer> height = new LinkedList<>();
            int cnt = 0;
            height.add(Integer.parseInt(st.nextToken()));
            for (int i = 1; i < 20; i++) {
                int curr = Integer.parseInt(st.nextToken());
                boolean flag = false;
                for (int j = 0; j < i; j++) {
                    if (height.get(j) > curr) {
                        height.add(j, curr);
                        cnt += i - j;
                        flag = true;
                        break;
                    }
                }
                
                if (!flag) {
                    height.add(i, curr);
                }
            }
            
            ans.append(cnt).append("\n");
        }
        
        System.out.println(ans.toString());
    }
}