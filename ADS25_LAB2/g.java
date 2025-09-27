import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int val;
        Node next;
        Node() {}
        Node(int x) { val = x; }
        Node(int x, Node n) { val = x; next = n; }
    }

    static Node insert(Node head, Node node, int p) {
        if (p == 0) {
            node.next = head;
            return node;
        } else {
            Node cur = head;
            for (int i = 0; i < p - 1; i++) cur = cur.next;
            node.next = cur.next;
            cur.next = node;
            return head;
        }
    }

    static Node remove(Node head, int p) {
        if (p == 0) {
            return head == null ? null : head.next;
        } else {
            Node cur = head;
            for (int i = 1; i < p; i++) cur = cur.next;
            if (cur.next != null) cur.next = cur.next.next;
            return head;
        }
    }

    static Node replace(Node head, int p1, int p2) {
        if (p1 == 0) {
            Node toReplace = head;
            head = head.next;
            toReplace.next = null;
            return insert(head, toReplace, p2);
        } else {
            Node current = head;
            for (int i = 0; i < p1 - 1; i++) current = current.next;
            Node toReplace = current.next;
            current.next = current.next.next;
            toReplace.next = null;
            return insert(head, toReplace, p2);
        }
    }

    static Node reverse(Node head) {
        Node prev = null, cur = head, nxt;
        while (cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }

    static void print(Node head, StringBuilder out) {
        if (head == null) {
            out.append("-1\n");
        } else {
            Node cur = head;
            while (cur != null) {
                out.append(cur.val).append(' ');
                cur = cur.next;
            }
            out.append('\n');
        }
    }

    static Node cyclic_left(Node head, int x) {
        if (x == 0 || head == null || head.next == null) return head;
        Node cur = head;
        int size = 1;
        while (cur.next != null) { cur = cur.next; size++; }
        x %= size;
        if (x == 0) return head;
        Node tail = cur;
        tail.next = head;
        while (x-- > 0) { head = head.next; tail = tail.next; }
        tail.next = null;
        return head;
    }

    static Node cyclic_right(Node head, int x) {
        if (x == 0 || head == null || head.next == null) return head;
        Node cur = head;
        int size = 1;
        while (cur.next != null) { cur = cur.next; size++; }
        x %= size;
        if (x == 0) return head;
        Node tail = cur;
        tail.next = head;
        int y = size - x;
        while (y-- > 0) { head = head.next; tail = tail.next; }
        tail.next = null;
        return head;
    }

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
        StringBuilder out = new StringBuilder();
        Node head = null;

        while (true) {
            int command = fs.nextInt();
            if (command == 0) break;
            else if (command == 1) {
                int x = fs.nextInt();
                int p = fs.nextInt();
                head = insert(head, new Node(x), p);
            } else if (command == 2) {
                int p = fs.nextInt();
                head = remove(head, p);
            } else if (command == 3) {
                print(head, out);
            } else if (command == 4) {
                int p1 = fs.nextInt();
                int p2 = fs.nextInt();
                head = replace(head, p1, p2);
            } else if (command == 5) {
                head = reverse(head);
            } else if (command == 6) {
                int x = fs.nextInt();
                head = cyclic_left(head, x);
            } else if (command == 7) {
                int x = fs.nextInt();
                head = cyclic_right(head, x);
            }
        }
        System.out.print(out.toString());
    }
}