import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[] cal = {'+', '-', '*'};
    static char[] sel;
    static List<String> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            N = Integer.parseInt(br.readLine());
            
            sel = new char[N-1];
            list = new ArrayList<>();
            perm(0);
            
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                ans.append(list.get(i)).append("\n");
            }
            ans.append("\n");
        }
        
        System.out.println(ans.toString());
    }
    
    public static void perm(int idx) {
        if (idx == N-1) {
            if (check(sel)) {
                StringBuilder sb = new StringBuilder();
                int t = 1;
                sb.append(t);
                for (char s : sel) {
                    if (s == '*') {
                        sb.append(" ");
                    } else {
                        sb.append(s);
                    }
                    sb.append(++t);
                }
                
                list.add(sb.toString());
            }
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            sel[idx] = cal[i];
            perm(idx+1);
        }
    }
    
    public static boolean check(char[] sel) {
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int idx = 1;
        for (int i = 0; i < N-1; i++) {
            if (sel[i] == '*') {
                idx = idx * 10 + ((idx%10) + 1);
            } else {
		        nums.add(idx);
		        idx = (idx%10) + 1;
                
                ops.add(sel[i]);
            }
        }
        nums.add(idx);
        int tmp = nums.get(0);
        for (int i = 0; i < ops.size(); i++) {
            if (ops.get(i) == '+') tmp += nums.get(i+1);
            else tmp -= nums.get(i+1);
        }
        
        if (tmp == 0) return true;
        else return false;
    } 
}