import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        char[] st = new char[s.length()];
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (top > 0 && st[top - 1] == c) top--;
            else st[top++] = c;
        }
        System.out.println(top == 0 ? "YES" : "NO");
    }
}