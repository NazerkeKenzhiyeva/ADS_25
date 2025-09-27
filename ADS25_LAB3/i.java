import java.util.*;

public class Main {
    static boolean binsearch(int[] nums, int size, int target) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int target = sc.nextInt();
        if (binsearch(arr, n, target))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}