import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] p = new int[3][2];

		Map<Integer, Integer> mapX = new HashMap<>();
		Map<Integer, Integer> mapY = new HashMap<>();

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				p[i][j] = Integer.parseInt(st.nextToken());
				if (j == 0) {
					mapX.put(p[i][j], mapX.getOrDefault(p[i][j], 0) + 1);
				} else {
					mapY.put(p[i][j], mapY.getOrDefault(p[i][j], 0) + 1);
				}

			}
		}

//		System.out.println(mapX);
//		System.out.println(mapY);
		
		StringBuilder sb = new StringBuilder();
		
		for (int x : mapX.keySet()) {
			if (mapX.get(x) % 2 == 1) sb.append(x + " ");
		}
		
		for (int y : mapY.keySet()) {
			if (mapY.get(y) % 2 == 1) sb.append(y);
		}
		
		System.out.println(sb);
	}
}
