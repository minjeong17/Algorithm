import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int sab = Integer.parseInt(br.readLine());
        int fab = Integer.parseInt(br.readLine());
        
        if (sab <= fab) System.out.println("high speed rail");
        else System.out.println("flight");
    }
}