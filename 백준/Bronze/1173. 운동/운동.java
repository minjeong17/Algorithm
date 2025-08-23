import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int m = sc.nextInt(); 
        int M = sc.nextInt(); 
        int T = sc.nextInt(); 
        int R = sc.nextInt(); 

        int cur = m;   // 현재 맥박
        int time = 0;  // 총 시간
        int cnt = 0;   // 운동 횟수

        // 불가능한 경우 (운동 한번도 못함)
        if (m + T > M) {
            System.out.println(-1);
            return;
        }

        while (cnt < N) {
            if (cur + T <= M) { 
                // 운동 가능
                cur += T;
                cnt++;
            } else {
                // 운동 불가능 → 휴식
                cur = Math.max(m, cur - R);
            }
            time++;
        }

        System.out.println(time);
    }
}
