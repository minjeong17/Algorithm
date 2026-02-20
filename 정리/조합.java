import java.util.Arrays;

public class 조합 {
    static int[] arr;
    static int N;
    static int[] sel;

    public static void main(String[] args) {
        arr = new int[] {1, 2, 3, 4};
        N = arr.length;

        sel = new int[2];

        comb(0, 0);
    }

    public static void comb(int idx, int sidx) {
        if (sidx == 2) {
            System.out.println(Arrays.toString(sel));
            return;
        }

        for (int i = idx; i < N; i++) {
            sel[sidx] = arr[i];
            comb(i, sidx+1);
        }
    }
}
