import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] freq = new int[1001];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            freq[arr[i]]++;
        }
        int maxFreq = 0;
        for (int i = 0; i < 1001; i++) 
            if (freq[i] > maxFreq) maxFreq = freq[i];
        for (int i = 1000; i >= 0; i--) 
            if (freq[i] == maxFreq) System.out.print(i + " ");
    }
}