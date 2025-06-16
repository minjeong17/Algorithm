import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            br.readLine();
            System.out.println(0);
        }
        else {
            int maxX = Integer.MIN_VALUE; int minX = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE; int minY = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int currX = Integer.parseInt(st.nextToken());
                int currY = Integer.parseInt(st.nextToken());

                maxX = Math.max(maxX, currX); minX = Math.min(minX, currX);
                maxY = Math.max(maxY, currY); minY = Math.min(minY, currY);
            }

            System.out.println((maxX-minX) * (maxY-minY));
        }
    }
}
