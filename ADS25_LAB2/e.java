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
        int n = fs.nextInt();

        String[] kept = new String[n];
        int sz = 0;
        String head = null;

        for (int i = 0; i < n; i++) {
            String s = fs.next();        
            if (sz == 0 || !head.equals(s)) {
                kept[sz++] = s;                            head = s;
            }
        }

        StringBuilder out = new StringBuilder();
        out.append("All in all: ").append(sz).append('\n');
        out.append("Students:\n");
        for (int i = sz - 1; i >= 0; i--) 
            out.append(kept[i]).append('\n');

        System.out.print(out.toString());
    }
}