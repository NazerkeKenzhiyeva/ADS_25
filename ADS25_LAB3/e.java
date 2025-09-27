import java.util.*;

public class Main {

    static boolean check(long n, long cur, long[][] arr, long k) {
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cur > Math.max(arr[i][2], arr[i][3])) {
                cnt++;
            }
        }
        return cnt >= k;
    }

    static long ans(long left, long right, long n, long[][] arr, long k) {
        long answer = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(n, mid, arr, k)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();

        long[][] arr = new long[(int)n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = sc.nextLong();
            }
        }

        long result = ans(0, (long)Math.pow(10, 10), n, arr, k) - 1;
        System.out.println(result);
    }
}