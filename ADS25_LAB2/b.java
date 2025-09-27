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
        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            do { c = read(); } while (c != -1 && c <= 32);
            if (c == -1) return null;
            while (c != -1 && c > 32) { sb.append((char)c); c = read(); }
            return sb.toString();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();
        int K = fs.nextInt();
        String[] w = new String[N];
        for (int i = 0; i < N; i++) w[i] = fs.next();

        K %= N;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) out.append(' ');
            out.append(w[(i + K) % N]);
        }
        System.out.println(out.toString());
    }
}