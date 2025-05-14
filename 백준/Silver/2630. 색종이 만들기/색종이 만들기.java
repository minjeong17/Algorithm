import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] paper;
	static int cnt0, cnt1;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition(0, 0, N);
		
		System.out.println(cnt0 + "\n" + cnt1);
		
	}
	
	

	private static void partition(int startR, int startC, int n) {
		
		if (count(startR, startC, n)) {
			if (paper[startR][startC] == 0) cnt0++;
			else cnt1++;
			return;
		}
		
		int newN = n / 2;
		partition(startR, startC, newN);
		partition(startR + newN, startC, newN);
		partition(startR, startC + newN, newN);
		partition(startR + newN, startC + newN, newN);
	}



	private static boolean count(int startR, int startC, int n) {
		
//		System.out.println(startR + " " + startC + " " + n);
		
		int curr = paper[startR][startC];
		for (int i = startR; i < startR + n; i++) {
			for (int j = startC; j < startC + n; j++) {
				if (paper[i][j] != curr) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
