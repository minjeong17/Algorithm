import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        String[] channels = new String[N];
        int KBS1Pos = 0;
        int KBS2Pos = 0;
        for(int i=0; i<N; i++) {
            String currChannel = br.readLine();
            if(currChannel.equals("KBS1")) KBS1Pos = i;
            else if(currChannel.equals("KBS2")) KBS2Pos = i;
        }
        boolean flag = false;
	if (KBS1Pos > KBS2Pos) flag = true;

        int pointer = 0;
        while (KBS1Pos > pointer) {
            sb.append("1");
            pointer++;
        }
        
        while (KBS1Pos > 0) {
            sb.append("4");
            KBS1Pos--;
            pointer--;
        }
        
	if (flag) KBS2Pos++;
        while (KBS2Pos > pointer) {
            sb.append("1");
            pointer++;
        }
        
        while (KBS2Pos > 1) {
            sb.append("4");
            KBS2Pos--;
            pointer--;
        }
        System.out.println(sb);
    }
}