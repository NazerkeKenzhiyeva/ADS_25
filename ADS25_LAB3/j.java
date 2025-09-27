import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        int left = 1;
        int right = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            right = Math.max(right, ar[i]);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long reqHours = 0;

            for (int i = 0; i < n; i++) {
                reqHours += (ar[i] + mid - 1) / mid;
            }

            if (reqHours <= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}