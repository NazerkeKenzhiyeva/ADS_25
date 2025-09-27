import java.io.*;

public class Main {
    static class FastScanner {
        private final InputStream in = new BufferedInputStream(System.in);
        private final byte[] buf = new byte[1 << 16];
        private int p = 0, n = 0;
        private int read() throws IOException { if (p >= n) { n = in.read(buf); p = 0; if (n <= 0) return -1; } return buf[p++]; }
        int nextInt() throws IOException { int c, s = 1, x = 0; do { c = read(); } while (c <= 32); if (c=='-'){ s=-1; c=read(); } while (c>32){ x = x*10 + (c-'0'); c = read(); } return x*s; }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long target = fs.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextInt();

        int left = 0, best = Integer.MAX_VALUE;
        long sum = 0;
        for (int right = 0; right < n; right++) {
            sum += a[right];
            while (sum >= target) {
                int len = right - left + 1;
                if (len < best) best = len;
                sum -= a[left++];
            }
        }
        System.out.println(best == Integer.MAX_VALUE ? -1 : best);
    }
}