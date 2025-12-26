import java.io.*;
import java.util.*;

public class Main  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numA = Integer.parseInt(st.nextToken());
        int numB = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numA; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        int unionCnt = setA.size();
        int interCnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numB; i++) {
            int b = Integer.parseInt(st.nextToken());

            if (setA.contains(b)) {
                interCnt++;
            } else {
                unionCnt++;
            }
        }

        System.out.println(unionCnt - interCnt);
    }
}
