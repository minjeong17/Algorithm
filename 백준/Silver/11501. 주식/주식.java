import java.io.*;
import java.util.*;

class Main {

    // 빠른 입력
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do { c = readByte(); } while (c <= ' ');

            long sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = fs.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) a[i] = fs.nextInt();

            long profit = 0;
            int max = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (a[i] > max) max = a[i];
                else profit += (max - a[i]);
            }

            sb.append(profit);
            if (t < T - 1) sb.append('\n');
        }
        System.out.print(sb);
    }
}
