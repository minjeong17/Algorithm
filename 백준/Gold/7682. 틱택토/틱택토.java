import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input;
        StringBuilder ans = new StringBuilder();
        while (!(input = br.readLine()).equals("end")) {
            int numX = 0;
            int numO = 0;
            char[][] map = new char[3][3];
            for (int i = 0; i < 9; i++) {
                char ch = input.charAt(i);
                if (ch == 'X') numX++;
                else if (ch == 'O') numO++;
                
                map[i/3][i%3] = ch;
            }
            
            if (numX == numO || numX - numO == 1) {
                int cntX = 0;
                int cntO = 0;
                for (int i = 0; i < 3; i++) {
                    if (map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                        if (map[i][0] == 'X') cntX++;
                        else if (map[i][0] == 'O') cntO++;
                    }    
                    if (map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                        if (map[0][i] == 'X') cntX++;
                        else if (map[0][i] == 'O') cntO++;
                    }
                }
                if (map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
                    if (map[0][0] == 'X') cntX++;
                    else if (map[0][0] == 'O') cntO++;
                }
                if (map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
                    if (map[0][2] == 'X') cntX++;
                    else if (map[0][2] == 'O') cntO++;
                }

                if (cntX > 0 && cntO > 0) ans.append("invalid\n");
                else if (cntX > 0 && numX - numO == 1)  ans.append("valid\n");
                else if (cntO > 0 && numX == numO) ans.append("valid\n");
                else if (cntX == 0 && cntO == 0 && numX + numO == 9 && numX - numO == 1) ans.append("valid\n");
                else ans.append("invalid\n");
            } else {
                ans.append("invalid\n");
                continue;
            }
        }
        
        System.out.println(ans.toString());
    }
}