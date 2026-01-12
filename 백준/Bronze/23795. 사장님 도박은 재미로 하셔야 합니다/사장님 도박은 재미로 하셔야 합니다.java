import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int input;
        int answer = 0;
        while ((input = Integer.parseInt(br.readLine())) != -1) {
            answer += input;
        } 
        
        System.out.println(answer);
    }
}