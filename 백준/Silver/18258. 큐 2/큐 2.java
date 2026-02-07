import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        int last = -1;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");
            if ("push".equals(cmd[0])) {
                int num = Integer.parseInt(cmd[1]);
                q.add(num);
                last = num;
            } else if ("pop".equals(cmd[0])) {
                if (q.isEmpty()) ans.append("-1\n");
                else {
                    ans.append(q.poll()).append("\n");
                    if (q.isEmpty()) last = -1;
                }
            } else if ("size".equals(cmd[0])) {
                ans.append(q.size()).append("\n");
            } else if ("empty".equals(cmd[0])) {
                if (q.isEmpty()) ans.append("1\n");
                else ans.append("0\n");
            } else if ("front".equals(cmd[0])) {
                if (q.isEmpty()) ans.append("-1\n");
                else ans.append(q.peek()).append("\n");
            } else {
                ans.append(last).append("\n");
            }
        }
        
        System.out.println(ans.toString());
    }
}