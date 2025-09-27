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
        long nextLong() throws IOException {
            int c; long s = 1, x = 0;
            do { c = read(); } while (c <= 32);
            if (c == '-') { s = -1; c = read(); }
            while (c > 32) { x = x * 10 + (c - '0'); c = read(); }
            return x * s;
        }
    }

    static class ListNode {
        long val;
        ListNode next;
        ListNode(long v) { val = v; }
    }

    static class Linkedlist {
        ListNode head, tail;
        void push_back(long v) {
            ListNode t = new ListNode(v);
            if (head == null) head = tail = t;
            else { tail.next = t; tail = t; }
        }
    }

    static long maxSubarraySum(ListNode head) {
        long best = Long.MIN_VALUE, cur = 0;
        for (ListNode p = head; p != null; p = p.next) {
            long x = p.val;
            cur = (cur < 0) ? x : (cur + x);
            if (cur > best) best = cur;
        }
        return best;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        Linkedlist ll = new Linkedlist();
        for (int i = 0; i < n; i++) ll.push_back(fs.nextLong());
        System.out.println(maxSubarraySum(ll.head));
    }
}