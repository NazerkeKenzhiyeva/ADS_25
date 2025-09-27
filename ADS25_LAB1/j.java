import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new ArrayDeque<>();
        char c = sc.next().charAt(0);

        while (c != '!') {
            if (c == '*') {
                if (!dq.isEmpty()) {
                    int ans = dq.peekFirst() + dq.peekLast();
                    System.out.println(ans);
                    if (dq.size() == 1) {
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                        dq.pollLast();
                    }
                } else {
                    System.out.println("error");
                }
            } else {
                int num = sc.nextInt();
                if (c == '+') dq.addFirst(num);
                else if (c == '-') dq.addLast(num);
            }
            c = sc.next().charAt(0);
        }
    }
}