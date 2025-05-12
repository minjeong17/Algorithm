import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] arr2 = new int[N*M];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr2[idx++] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(arr2);
		int minH = arr2[0];
		int maxH = arr2[arr2.length-1];
		if (minH == maxH) System.out.println(0 + " " + arr2[0]);
		else {
			
			int ansT = Integer.MAX_VALUE;
			int ansH = Integer.MIN_VALUE;
			
			outer:for (int targetH = maxH; targetH >= minH; targetH--) {
				int tmpTime = 0;
				int b = B;
				
				for (int i = N*M-1; i >= 0; i--) {
					int currH = arr2[i];
					if (currH < targetH) {
						int diff = targetH - currH;
						if (b >= diff) {
							tmpTime += diff;
							b -= diff;
						}
						else continue outer;
					} else if (currH > targetH) {
						tmpTime += (currH - targetH) * 2;
						b += currH - targetH;
					}
				}
				
				
				if (tmpTime < ansT) {
					ansT = tmpTime;
					ansH = targetH;
				}
			}
			
			System.out.println(ansT + " " + ansH);
		}
	}
}
