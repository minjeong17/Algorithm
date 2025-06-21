import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (N == 1) System.out.println(1);
		else {
			int frontIdx = 0; int rearIdx = 1;
			int ans = Integer.MIN_VALUE;
			Map<Integer, Integer> cntMap = new HashMap<>();
			cntMap.put(arr[0], cntMap.getOrDefault(arr[0], 0) + 1);
			cntMap.put(arr[1], cntMap.getOrDefault(arr[1], 0) + 1);

			while (rearIdx < N) {
				if (cntMap.size() <= 2) {
					ans = Integer.max(ans, rearIdx-frontIdx+1);
					rearIdx++;
					if (rearIdx < N) {
						int next = arr[rearIdx];
						cntMap.put(next, cntMap.getOrDefault(next, 0) + 1);
					}
				} else {
					int prev = arr[frontIdx++];
					if (cntMap.get(prev) == 1) {
						cntMap.remove(prev);
					} else {
						cntMap.put(prev, cntMap.get(prev)-1);
					}
				}

			}

			System.out.println(ans);
		}
	}
}
