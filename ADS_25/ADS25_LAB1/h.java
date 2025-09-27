import java.io.*;

public class Main {
    static boolean isPrime(long x) {
        if (x < 2) return false;
        if (x % 2 == 0) return x == 2;
        for (long d = 3; d * d <= x; d += 2)
            if (x % d == 0) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        System.out.println(isPrime(n) ? "YES" : "NO");
    }
}