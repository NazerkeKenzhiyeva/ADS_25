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
        StringBuilder out = new StringBuilder();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] cnt = new int[65536];
            ArrayDeque<Character> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char c = fs.next().charAt(0);
                cnt[c]++;
                q.addLast(c);
                while (!q.isEmpty() && cnt[q.peekFirst()] > 1) q.pollFirst();
                if (q.isEmpty()) out.append(-1).append(' ');
                else out.append(q.peekFirst()).append(' ');
            }
            out.append('\n');
        }
        System.out.print(out.toString());
    }
}