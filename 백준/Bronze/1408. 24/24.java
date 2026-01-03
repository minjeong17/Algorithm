import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] now = br.readLine().split(":");
        String[] start = br.readLine().split(":");

        int nowSec = Integer.parseInt(now[0]) * 3600 + Integer.parseInt(now[1]) * 60 + Integer.parseInt(now[2]);
        int startSec = Integer.parseInt(start[0]) * 3600 + Integer.parseInt(start[1]) * 60 + Integer.parseInt(start[2]);

        int ans = startSec - nowSec;
        if (ans < 0) ans += 24 * 3600;
        int ansHour = ans / 3600;
        int ansMin = (ans % 3600) / 60;
        int ansSec = (ans % 3600) % 60;

        StringBuilder answer = new StringBuilder();
        if (ansHour < 10) answer.append("0");
        answer.append(ansHour).append(":");
        if (ansMin < 10) answer.append("0");
        answer.append(ansMin).append(":");
        if (ansSec < 10) answer.append("0");
        answer.append(ansSec);

        System.out.println(answer.toString());
    }
}
