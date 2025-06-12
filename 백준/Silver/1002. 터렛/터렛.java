import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x1 - x2;
            int dy = y1 - y2;
            int distSq = dx * dx + dy * dy;
            int sumR = (r1 + r2) * (r1 + r2);
            int diffR = (r1 - r2) * (r1 - r2);

            if (x1 == x2 && y1 == y2) {
                if (r1 == r2) {
                    sb.append(-1 + "\n"); // 같은 원
                } else {
                    sb.append(0 + "\n"); // 중심 같고 반지름 다름
                }
            } else {
                if (distSq == sumR || distSq == diffR) {
                    sb.append(1 + "\n"); // 외접 or 내접
                } else if (diffR < distSq && distSq < sumR) {
                    sb.append(2 + "\n"); // 두 점에서 만남
                } else {
                    sb.append(0 + "\n"); // 만나지 않음
                }
            }
        }

        System.out.println(sb);
    }
}
