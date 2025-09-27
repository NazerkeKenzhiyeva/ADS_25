import java.io.*;

public class Main {
    // Fast input
    static class FastScanner {
        private final InputStream in = new BufferedInputStream(System.in);
        private final byte[] buf = new byte[1 << 16];
        private int p = 0, n = 0;
        private int read() throws IOException {
            if (p >= n) { n = in.read(buf); p = 0; if (n <= 0) return -1; }
            return buf[p++];
        }
        int nextInt() throws IOException {
            int c, sgn = 1, x = 0;
            do { c = read(); } while (c <= 32);
            if (c == '-') { sgn = -1; c = read(); }
            while (c > 32) { x = x * 10 + (c - '0'); c = read(); }
            return x * sgn;
        }
    }

    static int bSearchInc(int[] a, int target, int n) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + ((r - l) >>> 1);
            if (target < a[m]) r = m - 1;
            else if (target > a[m]) l = m + 1;
            else return m;
        }
        return -1;
    }

    static int bSearchDec(int[] a, int target, int n) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + ((r - l) >>> 1);
            if (target > a[m]) r = m - 1;
            else if (target < a[m]) l = m + 1;
            else return m;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();
        int[] targets = new int[n];
        for (int i = 0; i < n; i++) targets[i] = fs.nextInt();

        int a = fs.nextInt();
        int b = fs.nextInt();

        int[][] mat = new int[a][b];
        for (int i = 0; i < a; i++)
            for (int j = 0; j < b; j++)
                mat[i][j] = fs.nextInt();

        for (int i = 0; i < n; i++) {
            int t = targets[i];
            boolean found = false;
            for (int row = 0; row < a; row++) {
                int idx = (row % 2 == 0)
                        ? bSearchDec(mat[row], t, b)   // even rows are descending
                        : bSearchInc(mat[row], t, b);  // odd rows are ascending
                if (idx != -1) {
                    out.append(row).append(' ').append(idx).append('\n');
                    found = true;
                    break;
                }
            }
            if (!found) out.append(-1).append('\n');
        }

        System.out.print(out.toString());
    }