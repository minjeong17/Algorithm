import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        
        String input;
        StringBuilder ans = new StringBuilder();
        while (!(input = br.readLine()).equals("end")) {
            boolean chk1 = false;
            int[] ifV = new int[input.length()]; // 1 : 모음, 0 : 자음
            boolean chk23 = true;
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                
                if (vowels.contains(ch)) {
                    chk1 = true;
                    ifV[i] = 1;
                }
                
                if (i > 1 && (ifV[i] + ifV[i-1] + ifV[i-2] == 0 || ifV[i] + ifV[i-1] + ifV[i-2] == 3)) {
                    chk23 = false;
                    break;
                } 
                                    
                if (ch != 'e' && ch != 'o' && i > 0 && ch == input.charAt(i-1)) {
                    chk23 = false;
                    break;
                }  
            }
            
            if (chk1 && chk23) {
                ans.append("<").append(input).append("> is acceptable.").append("\n");
            } else {
                ans.append("<").append(input).append("> is not acceptable.").append("\n");
            }
        }
        
        System.out.println(ans.toString());
    }
}