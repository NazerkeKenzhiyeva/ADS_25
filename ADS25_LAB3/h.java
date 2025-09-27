import java.io.*;

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
            int c; long s = 1, x = 0;
            do { c = read(); } while (c <= 32);
            if (c == '-') { s = -1; c = read(); }
            while (c > 32) { x = x * 10 + (c - '0'); c = read(); }
            return x * s;
        }
        int nextInt() throws IOException { return (int) nextLong(); }
    }

    static int lowerBound(long[] a, long x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < x) l = m + 1; else r = m;
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        long[] pref = new long[n];
        long s = 0;
        for (int i = 0; i < n; i++) { s += fs.nextLong(); pref[i] = s; }
        StringBuilder out = new StringBuilder();
        for (int q = 0; q < m; q++) {
            long x = fs.nextLong();
            int idx = lowerBound(pref, x);
            if (idx >= n) idx = n - 1;
            out.append(idx + 1).append('\n');
        }
        System.out.print(out.toString());
    }
}