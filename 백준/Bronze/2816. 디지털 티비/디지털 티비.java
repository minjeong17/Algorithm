import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int num1 = -1;
        int num2 = -1;
        for (int i = 0; i < N; i++) {
            String ch = br.readLine();
            if ("KBS1".equals(ch)) {
                num1 = i;
            } else if ("KBS2".equals(ch)) {
                num2 = i;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        if (num1 < num2) {
            for (int i = 0; i < num2; i++) {
                ans.append("1");
            }
            for (int i = 0; i < num2; i++) {
                ans.append("4");
            }
            for (int i = 0; i < num1+1; i++) {
                ans.append("1");
            }
            for (int i = 0; i < num1+1; i++) {
                ans.append("4");
            }
        } else {
            for (int i = 0; i < num2; i++) {
                ans.append("1");
            }
            for (int i = 0; i < num2; i++) {
                ans.append("4");
            }
            for (int i = 0; i < num1; i++) {
                ans.append("1");
            }
            for (int i = 0; i < num1; i++) {
                ans.append("4");
            }
        }
        
        
        System.out.println(ans.toString());
    }
}