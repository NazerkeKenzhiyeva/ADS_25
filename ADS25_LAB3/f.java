import java.util.*;

public class Main {

    static long bs(long left, long right, long target, long[] a) {
        long ans = 0;
        if (target < a[0]) {
            return 0;
        } else if (target >= a[(int) right]) {
            return right + 1;
        } else {
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (a[(int) mid] <= target) {
                    left = mid + 1;
                    ans = mid;
                } else {
                    right = mid - 1;
                }
            }
            return ans + 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        int test = sc.nextInt();
        while (test-- > 0) {
            long x = sc.nextLong();
            long newSize = bs(0, n - 1, x, arr);

            long sum = 0;
            for (int i = 0; i < newSize; i++) {
                sum += arr[i];
            }
            System.out.println(newSize + " " + sum);
        }
    }
}