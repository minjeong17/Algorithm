import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int newSc = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        if (N == 0) {
            System.out.println(1);
        } else {
            st = new StringTokenizer(br.readLine());
            
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                nums.add(Integer.parseInt(st.nextToken()));
            }
            nums.add(newSc);
            Collections.sort(nums, (o1, o2) -> o2 - o1);
        
            int answer = nums.indexOf(newSc) + 1;
            int idx = nums.lastIndexOf(newSc);
        
            if (idx >= P) answer = -1;
                
            System.out.println(answer);  
        }
         
    }
}