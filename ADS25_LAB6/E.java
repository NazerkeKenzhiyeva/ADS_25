import java.io.*;

public class E {
    static final BufferedInputStream in = new BufferedInputStream(System.in);
    static int read() throws IOException { return in.read(); }
    static boolean sp(int c){ return c<=32; }
    static int nextInt() throws IOException {
        int c; do c = read(); while (sp(c));
        int s = 1; if (c=='-'){ s=-1; c=read(); }
        int x = 0; while (c > 32) { x = x*10 + c - '0'; c = read(); }
        return x * s;
    }

    static void qsortDesc(int[] a, int l, int r){
        while (l < r) {
            int i = l, j = r, p = a[l + ((r - l) >> 1)];
            while (i <= j) {
                while (a[i] > p) i++;
                while (a[j] < p) j--;
                if (i <= j) {
                    int t = a[i]; a[i] = a[j]; a[j] = t;
                    i++; j--;
                }
            }
            if (j - l < r - i) { if (l < j) qsortDesc(a, l, j); l = i; }
            else { if (i < r) qsortDesc(a, i, r); r = j; }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt(), m = nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) a[i][j] = nextInt();

        int[] col = new int[n];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) col[i] = a[i][j];
            qsortDesc(col, 0, n - 1);
            for (int i = 0; i < n; i++) a[i][j] = col[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { sb.append(a[i][j]).append(' '); }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}