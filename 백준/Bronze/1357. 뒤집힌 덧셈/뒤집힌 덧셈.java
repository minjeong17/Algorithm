import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder X = new StringBuilder();
        X.append(st.nextToken());
        StringBuilder Y = new StringBuilder();
        Y.append(st.nextToken());

        int revX = Integer.parseInt(X.reverse().toString());
        int revY = Integer.parseInt(Y.reverse().toString());

        StringBuilder answer = new StringBuilder();
        answer.append((revX + revY)+"").reverse();

        System.out.println(Integer.parseInt(answer.toString()));
    }
}
