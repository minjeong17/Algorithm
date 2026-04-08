import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] numArr = br.readLine().split("");
        
        int answer = 1;
        int idx = 0;
        while (idx < numArr.length) {
            String n = String.valueOf(answer);
            for (int i = 0; i < n.length(); i++) {
                if (numArr[idx].equals(String.valueOf(n.charAt(i)))) {
                    idx++;
                }
                
                if (idx == numArr.length) break;
            }
            
            if (idx < numArr.length) answer++;
        }

	    System.out.println(answer);
    }
}