import java.io.*;
import java.util.*;

public class Main {
    static class ListNode {
        String val;
        ListNode next, prev;
        ListNode(String v) { val = v; }
    }

    static class DoubleLinkedList {
        int size = 0;
        ListNode head, tail;

        void add_front(String val, StringBuilder out) {
            ListNode t = new ListNode(val);
            if (head == null) { head = tail = t; }
            else { t.next = head; head.prev = t; head = t; }
            size++; out.append("ok\n");
        }
        void add_back(String val, StringBuilder out) {
            ListNode t = new ListNode(val);
            if (head == null) { head = tail = t; }
            else { tail.next = t; t.prev = tail; tail = t; }
            size++; out.append("ok\n");
        }
        void erase_front(StringBuilder out) {
            if (size == 0) { out.append("error\n"); return; }
            out.append(head.val).append('\n');
            if (size == 1) { clear(); return; }
            head = head.next; head.prev = null; size--;
        }
        void erase_back(StringBuilder out) {
            if (size == 0) { out.append("error\n"); return; }
            out.append(tail.val).append('\n');
            if (size == 1) { clear(); return; }
            tail = tail.prev; tail.next = null; size--;
        }
        void clear() { head = tail = null; size = 0; }
        void front(StringBuilder out) {
            if (size == 0) out.append("error\n");
            else out.append(head.val).append('\n');
        }
        void back(StringBuilder out) {
            if (size == 0) out.append("error\n");
            else out.append(tail.val).append('\n');
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        DoubleLinkedList dll = new DoubleLinkedList();
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            int sp = line.indexOf(' ');
            String cmd = sp == -1 ? line : line.substring(0, sp);
            String arg = sp == -1 ? null : line.substring(sp + 1);

            switch (cmd) {
                case "add_front": dll.add_front(arg, out); break;
                case "add_back": dll.add_back(arg, out); break;
                case "erase_front": dll.erase_front(out); break;
                case "erase_back": dll.erase_back(out); break;
                case "front": dll.front(out); break;
                case "back": dll.back(out); break;
                case "clear": dll.clear(); out.append("ok\n"); break;
                case "exit": out.append("goodbye\n"); System.out.print(out.toString()); return;
            }
        }
        System.out.print(out.toString());
    }
}