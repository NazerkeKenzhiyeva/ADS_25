import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node head = new Node(Integer.parseInt(st.nextToken()));
        Node cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new Node(Integer.parseInt(st.nextToken()));
            cur = cur.next;
        }
        cur = head;
        while (cur != null && cur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
        }
        StringBuilder sb = new StringBuilder();
        cur = head;
        while (cur != null) {
            sb.append(cur.val).append(" ");
            cur = cur.next;
        }
        System.out.println(sb.toString().trim());
    }
}