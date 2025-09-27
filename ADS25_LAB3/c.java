import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] a;

    static int bs(int p, char ch) {
        int l = 0, r = n - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (a[mid] == p) return mid;
            else if (a[mid] < p) l = mid + 1;
            else r = mid - 1;
        }
        return (ch == 'l') ? l : r;
    }

    static int pos(int l, int r) {
        return bs(r, 'r') - bs(l, 'l') + 1;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        n = fs.nextInt();
        k = fs.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextInt();
        Arrays.sort(a);

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < k; i++) {
            int l1 = fs.nextInt();
            int r1 = fs.nextInt();
            int l2 = fs.nextInt();
            int r2 = fs.nextInt();

            if (l1 <= l2 && r2 <= r1)
                out.append(pos(l1, r1)).append('\n');
            else if (l2 <= l1 && r1 <= r2)
                out.append(pos(l2, r2)).append('\n');
            else if (r2 >= l1 && r1 >= r2 && l1 >= l2)
                out.append(pos(l2, r1)).append('\n');
            else if (r1 >= l2 && r2 >= r1 && l2 >= l1)
                out.append(pos(l1, r2)).append('\n');
            else
                out.append(pos(l1, r1) + pos(l2, r2)).append('\n');
        }
        System.out.print(out.toString());
    }

    static class FastScanner {
        private final InputStream in = new BufferedInputStream(System.in);
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

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) != -1 && c <= 32);
            if (c == -1) return null;
            do { sb.append((char)c); } while ((c = readByte()) != -1 && c > 32);
            return sb.toString();
        }

        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }
}