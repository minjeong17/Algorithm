import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] tmp = br.readLine().split(",");
        List<Integer> originNums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            originNums.add(Integer.parseInt(tmp[i]));
        }

        List<Integer> nextNums;
        for (int i = 0; i < K; i++) {
            nextNums = new ArrayList<>();
            for (int j = 0; j < originNums.size()-1; j++) {
                nextNums.add(originNums.get(j+1)-originNums.get(j));
            }
            originNums = new ArrayList<>(nextNums);
        }

        StringBuilder ans = new StringBuilder();
        ans.append(originNums.get(0));
        for (int i = 1; i < originNums.size(); i++) {
            ans.append(",").append(originNums.get(i));
        }

        System.out.println(ans.toString());
    }
}
