import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        System.out.println(cal(A, B));
    }
    
    public static int cal(long A, long B) {
        Queue<Long> q = new LinkedList<>();
        q.add(A);
        
        int answer = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            
            for (int i = 0; i < len; i++) {
                long curr = q.poll();
                
                if (curr == B) return answer+1;
                
                if (curr*2 <= B) {
                    q.add(curr*2);
                }
                
                if (curr*10+1 <= B) {
                    q.add(curr*10+1);
                }
            }
            answer++;
        }  
        
        return -1;
    }
}