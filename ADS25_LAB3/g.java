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
        int k = fs.nextInt();
        int[] ar = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            ar[i] = fs.nextInt();
            if (ar[i] > max) max = ar[i];
        }

        long left = 1L, right = max;   
        while (left <= right) {
            long mid = left + ((right - left) >> 1); 
            long reqFlights = 0L;

            for (int x : ar) {
                reqFlights += (x + mid - 1) / mid;
                if (reqFlights > k) break;
            }

            if (reqFlights <= k) {
                right = mid - 1;  
            } else {
                left = mid + 1;   
            }
        }

        System.out.println(left);
    }
}