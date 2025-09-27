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
        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            do { c = read(); } while (c <= 32);
            if (c == '-') { s = -1; c = read(); }
            while (c > 32) { x = x * 10 + (c - '0'); c = read(); }
            return x * s;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) v[i] = fs.nextInt();

        int[] ans = new int[n];
        int[] st = new int[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            int x = v[i];
            while (top > 0 && st[top - 1] > x) top--;
            ans[i] = (top == 0) ? -1 : st[top - 1];
            st[top++] = x;
        }

        StringBuilder out = new StringBuilder(n * 3);
        for (int i = 0; i < n; i++) {
            if (i > 0) out.append(' ');
            out.append(ans[i]);
        }
        System.out.print(out.toString());
    }