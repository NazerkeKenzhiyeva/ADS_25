import java.io.*;

public class I {
    static void quickSort(char[] a, int l, int r) {
        while (l < r) {
            int i = l, j = r;
            char p = a[l + (r - l) / 2];
            while (i <= j) {
                while (a[i] < p) i++;
                while (a[j] > p) j--;
                if (i <= j) {
                    char t = a[i]; a[i] = a[j]; a[j] = t;
                    i++; j--;
                }
            }
            if (j - l < r - i) { if (l < j) quickSort(a, l, j); l = i; }
            else { if (i < r) quickSort(a, i, r); r = j; }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        char[] a = s.toCharArray();
        quickSort(a, 0, a.length - 1);
        System.out.print(new String(a));
    }
}