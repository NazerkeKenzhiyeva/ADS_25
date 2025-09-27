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

        List<Integer> primes = new ArrayList<>();
        int x = 1;
        while (primes.size() < 600) {
            x++;
            if (isPrime(x)) primes.add(x);
        }

        List<Integer> supers = new ArrayList<>();
        for (int i = 0; i < primes.size(); i++) {
            if (isPrime(i + 1)) supers.add(primes.get(i));
            if (supers.size() >= n) break;
        }

        System.out.println(supers.get(n - 1));
    }
}

