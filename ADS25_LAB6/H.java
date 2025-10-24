import java.io.*;
import java.util.*;

public class H {
    static String[] toks() throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) { sb.append(s).append(' '); }
        return sb.toString().trim().split("\\s+");
    }

    static void qsort(char[] a, int l, int r){
        while(l<r){
            int i=l, j=r; char p=a[l+((r-l)>>1)];
            while(i<=j){
                while(a[i]<p) i++;
                while(a[j]>p) j--;
                if(i<=j){ char t=a[i]; a[i]=a[j]; a[j]=t; i++; j--; }
            }
            if(j-l<r-i){ if(l<j) qsort(a,l,j); l=i; }
            else { if(i<r) qsort(a,i,r); r=j; }
        }
    }

    static char nextGreatest(char[] a, char t){
        int n=a.length, l=0, r=n;
        while(l<r){
            int m=(l+r)>>>1;
            if(a[m]<=t) l=m+1; else r=m;
        }
        return l<n ? a[l] : a[0];
    }

    static boolean isInt(String s){
        try{ Integer.parseInt(s); return true; } catch(Exception e){ return false; }
    }

    public static void main(String[] args) throws Exception {
        String[] x = toks();
        int n; char target; int start;
        if (isInt(x[0])) { n = Integer.parseInt(x[0]); start = 1; target = x[n+1].charAt(0); }
        else { target = x[0].charAt(0); n = Integer.parseInt(x[1]); start = 2; }
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) arr[i] = x[start+i].charAt(0);
        qsort(arr,0,n-1);
        System.out.print(nextGreatest(arr, target));
    }
}