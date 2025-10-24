import java.io.*;
import java.util.*;

public class G {
    static class Pair {
        String o, f;
    }

    static void quickSort(Pair[] a, int l, int r) {
        while (l < r) {
            int i = l, j = r;
            String p = a[l + (r - l) / 2].o;
            while (i <= j) {
                while (a[i].o.compareTo(p) < 0) i++;
                while (a[j].o.compareTo(p) > 0) j--;
                if (i <= j) {
                    Pair t = a[i]; a[i] = a[j]; a[j] = t;
                    i++; j--;
                }
            }
            if (j - l < r - i) { if (l < j) quickSort(a, l, j); l = i; }
            else { if (i < r) quickSort(a, i, r); r = j; }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        Map<String,String> curToOrig = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String old = st.nextToken(), nw = st.nextToken();
            if (curToOrig.containsKey(old)) {
                String orig = curToOrig.remove(old);
                curToOrig.put(nw, orig);
            } else {
                curToOrig.put(nw, old);
            }
        }
        int q = curToOrig.size();
        Pair[] arr = new Pair[q];
        int idx = 0;
        for (Map.Entry<String,String> e : curToOrig.entrySet()) {
            Pair p = new Pair();
            p.o = e.getValue();
            p.f = e.getKey();
            arr[idx++] = p;
        }
        quickSort(arr, 0, q - 1);
        StringBuilder out = new StringBuilder();
        out.append(q).append('\n');
        for (Pair p : arr) out.append(p.o).append(' ').append(p.f).append('\n');
        System.out.print(out.toString());
    }
}