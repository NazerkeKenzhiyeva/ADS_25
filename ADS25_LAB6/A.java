import java.io.*;

public class A {
    static boolean isVowel(char c) {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }

    static int key(char c) {
        return (isVowel(c) ? 0 : 1) * 100 + (c - 'a');
    }

    static void heapify(char[] a, int n, int i) {
        while (true) {
            int l = i * 2 + 1, r = l + 1, largest = i;
            if (l < n && key(a[l]) > key(a[largest])) largest = l;
            if (r < n && key(a[r]) > key(a[largest])) largest = r;
            if (largest == i) break;
            char t = a[i]; a[i] = a[largest]; a[largest] = t;
            i = largest;
        }
    }

    static void heapSort(char[] a) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; --i) heapify(a, n, i);
        for (int end = n - 1; end > 0; --end) {
            char t = a[0]; a[0] = a[end]; a[end] = t;
            heapify(a, end, 0);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedInputStream in = new BufferedInputStream(System.in);
        StringBuilder sb = new StringBuilder();
        int c, n = 0;
        while ((c = in.read()) != -1 && c <= 32) {}
        while (c > 32) { n = n * 10 + (c - '0'); c = in.read(); }
        while (c != -1 && c <= 32) c = in.read();
        sb.setLength(0);
        for (int i = 0; i < n && c != -1; i++, c = in.read()) sb.append((char)c);
        char[] arr = sb.toString().toCharArray();
        heapSort(arr);
        System.out.print(new String(arr));
    }
}