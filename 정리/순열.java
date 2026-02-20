import java.util.Arrays;

public class 순열 {
    static int[] arr;
    static int N;
    static int[] sel;
    static boolean[] visited;

    public static void main(String[] args) {
        arr = new int[] {1, 2, 3};
        N = arr.length;
        sel = new int[N];
        visited = new boolean[N];

        perm(0);
    }

    public static void perm(int idx) {
        if (idx == N) {
            System.out.println(Arrays.toString(sel));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                sel[idx] = arr[i];
                visited[i] = true;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
}
