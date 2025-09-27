import java.io.*;
import java.util.*;

public class Main {
    static boolean aBeatsB(int a, int b) {
        if (a == 0 && b == 9) return true;
        if (a == 9 && b == 0) return false;
        return a > b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        ArrayDeque<Integer> boris = new ArrayDeque<>(5);
        ArrayDeque<Integer> nursik = new ArrayDeque<>(5);

        for (int i = 0; i < 5; i++) boris.add(Integer.parseInt(st1.nextToken()));
        for (int i = 0; i < 5; i++) nursik.add(Integer.parseInt(st2.nextToken()));

        long moves = 0;
        long MAX = 10_000_000L;

        while (!boris.isEmpty() && !nursik.isEmpty() && moves < MAX) {
            int a = boris.pollFirst();
            int b = nursik.pollFirst();
            if (aBeatsB(a, b)) { boris.addLast(a); boris.addLast(b); }
            else { nursik.addLast(a); nursik.addLast(b); }
            moves++;
        }

        if (moves >= MAX) {
            System.out.println("blin nichya");
        } else if (nursik.isEmpty()) {
            System.out.println("Boris " + moves);
        } else {
            System.out.println("Nursik " + moves);
        }
    }
}