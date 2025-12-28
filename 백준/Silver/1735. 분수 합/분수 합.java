import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // a / b   c / d
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // num1 / num2
        int num1 = a * d + b * c;
        int num2 = b * d;

        int gcd = 1;
        int n1 = Math.max(num1, num2);
        int n2 = Math.min(num1, num2);
        while (true) {
            if (n1 % n2 == 0) {
                gcd = n2;
                break;
            }

            int tmp = n1 % n2;
            n1 = n2;
            n2 = tmp;
        }

        System.out.println(num1 / gcd + " " + num2 / gcd);
    }
}
