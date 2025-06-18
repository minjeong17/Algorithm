import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] points = new int[3][2];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        int x1 = points[0][0]; int y1 = points[0][1];
        int x2 = points[1][0]; int y2 = points[1][1];
        int x3 = points[2][0]; int y3 = points[2][1];

        int cross = (x2-x1)*(y3-y1) - (y2-y1)*(x3-x1);

        if (cross == 0) System.out.println(0);
        else if (cross > 0) System.out.println(1);
        else System.out.println(-1);

    }
}
