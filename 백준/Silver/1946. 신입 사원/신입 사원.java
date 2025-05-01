import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, (o1, o2) -> {
				return o1[0] - o2[0];
			});
			
//			 System.out.println(Arrays.deepToString(arr));

			int ans = 1;
			int tmp = arr[0][1];
			for (int i = 1; i < N; i++) {
				if (arr[i][1] < tmp) {
					ans++;
					tmp = arr[i][1];
				}
			}

			System.out.println(ans);
		}

	}
}
