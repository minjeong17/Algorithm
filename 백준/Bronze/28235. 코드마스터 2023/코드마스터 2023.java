import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String word = br.readLine();
        if (word.equals("SONGDO")) System.out.println("HIGHSCHOOL");
        else if (word.equals("CODE")) System.out.println("MASTER");
        else if (word.equals("2023")) System.out.println("0611");
        else System.out.println("CONTEST");
    }
}