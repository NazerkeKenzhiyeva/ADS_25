import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        Queue<Integer> qS = new ArrayDeque<>();
        Queue<Integer> qK = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'S') qS.add(i);
            else qK.add(i);
        }

        while (!qS.isEmpty() && !qK.isEmpty()) {
            int iS = qS.poll();
            int iK = qK.poll();
            if (iS < iK) qS.add(iS + n);
            else qK.add(iK + n);
        }

        System.out.println(qS.isEmpty() ? "KATSURAGI" : "SAKAYANAGI");
    }
}