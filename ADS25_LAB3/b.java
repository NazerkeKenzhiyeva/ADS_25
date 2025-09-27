import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int k = fs.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) ar[i] = fs.nextInt();

        long left = 0, right = (long) 1e15, ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            int cnt = 1;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (mid < sum + ar[i]) {
                    sum = 0;
                    cnt++;
                }
                if (mid < ar[i]) {
                    cnt = k + 1;
                }
                sum += ar[i];
            }
            if (cnt > k) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

    // Fast input reader
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
            do {
                sb.append((char) c);
            } while ((c = readByte()) != -1 && c > 32);
            return sb.toString();
        }

        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }
}
