import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int divA = Math.min(A, B) / 4;
        int modA = Math.min(A, B) % 4;
        int divB = Math.max(A, B) / 4;
        int modB = Math.max(A, B) % 4;

        if (modA == 0) {
            modA = 4;
            divA--;
        }

        if (modB == 0) {
            modB = 4;
            divB--;
        }

        System.out.println(Math.abs(divA-divB) + Math.abs(modA-modB));
    }
}
