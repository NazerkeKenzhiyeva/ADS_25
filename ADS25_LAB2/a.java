import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in = new BufferedInputStream(System.in);
        private final byte[] buf = new byte[1 << 16];
        private int p = 0, n = 0;
        private int read() throws IOException {
            if (p >= n) { n = in.read(buf); p = 0; if (n <= 0) return -1; }
            return buf[p++];
        }
        long nextLong() throws IOException {
            int c; do { c = read(); } while (c <= 32);
            long s = 1, x = 0;
            if (c == '-') { s = -1; c = read(); }
            while (c > 32) { x = x * 10 + (c - '0'); c = read(); }
            return x * s;
        }
        int nextInt() throws IOException { return (int) nextLong(); }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextLong();
        long k = fs.nextLong();

        int best = 0;
        long bestDiff = Math.abs(a[0] - k);
        for (int i = 1; i < n; i++) {
            long d = Math.abs(a[i] - k);
            if (d < bestDiff) { bestDiff = d; best = i; }
        }
        System.out.println(best);
    }
}