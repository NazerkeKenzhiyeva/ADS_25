import java.io.*;
import java.util.*;

public class Main{
    static class FastScanner {
        private final InputStream in = new BufferedInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
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
        StringBuilder out = new StringBuilder();
        int T = fs.nextInt();
        while (T-- > 0) {
            int N = fs.nextInt();
            ArrayDeque<Integer> d = new ArrayDeque<>(N);
            for (int i = N; i >= 1; --i) {
                d.addFirst(i);                              
                int k = i % d.size();                       
                for (int t = 0; t < k; ++t)
                    d.addFirst(d.removeLast());
            }

            Iterator<Integer> it = d.iterator();
            for (int i = 0; i < N; i++) {
                out.append(it.next());
                out.append(i + 1 == N ? '\n' : ' ');
            }
        }
        System.out.print(out.toString());
    }
}
