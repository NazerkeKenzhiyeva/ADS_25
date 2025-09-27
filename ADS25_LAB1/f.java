import java.io.*;
import java.util.*;

public class Main {
    static boolean isPrime(int x) {
        if (x < 2) return false;
        if (x % 2 == 0) return x == 2;
        for (int d = 3; d * d <= x; d += 2)
            if (x % d == 0) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int count = 0, x = 1, ans = -1;
        while (count < n) {
            x++;
            if (isPrime(x)) { count++; ans = x; }
        }
        System.out.println(ans);
    }
}