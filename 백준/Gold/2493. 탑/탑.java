import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] towers = new int[N];
        Stack<int[]> height = new Stack<>();
        StringBuilder ans = new StringBuilder();
        ans.append(0).append(" ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        towers[0] = Integer.parseInt(st.nextToken());
        height.push(new int[] {towers[0], 0});
        for (int i = 1; i < N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
           
            while (!height.isEmpty()) {
                int[] prev = height.pop();
                if (prev[0] < towers[i]) {
                    if (height.isEmpty()) ans.append("0 ");
                } else {
                    ans.append(prev[1]+1).append(" ");
                    height.push(new int[] {prev[0], prev[1]});
                    break;
                }
            }
            
            height.push(new int[] {towers[i], i});
        }
        
        System.out.println(ans.toString());
    }
}