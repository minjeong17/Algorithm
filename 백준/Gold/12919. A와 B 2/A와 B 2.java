import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        String T = br.readLine();
        
        if (find(S, T)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    
    public static boolean find(String S, String T) {
        Queue<String> q = new LinkedList<>();
        q.add(T);
        
        while (!q.isEmpty()) {
            String curr = q.poll();
            
            if (curr.equals(S)) return true;
            if (curr.length() < S.length()) continue;
            
            if (curr.charAt(curr.length()-1) == 'A') {
                q.add(curr.substring(0, curr.length()-1));
            } 
            if (curr.charAt(0) == 'B') {
                q.add(new StringBuilder(curr.substring(1)).reverse().toString());
            }
        }
        
        return false;
    }
}