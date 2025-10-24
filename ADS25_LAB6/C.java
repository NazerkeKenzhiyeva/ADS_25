import java.io.*;

public class C {
    static final BufferedInputStream in = new BufferedInputStream(System.in);
    static int read() throws IOException { return in.read(); }
    static boolean isSpace(int c){ return c<=32; }
    static int nextSign() throws IOException {
        int c; do c=read(); while (isSpace(c));
        int s=1; if(c=='-'){ s=-1; c=read(); }
        int x=0; while(c>32){ x=x*10 + c-'0'; c=read(); }
        return x*s;
    }
    static long nextLong() throws IOException {
        int c; do c=read(); while (isSpace(c));
        int s=1; if(c=='-'){ s=-1; c=read(); }
        long x=0; while(c>32){ x = x*10 + c-'0'; c=read(); }
        return s==1?x:-x;
    }

    static void quickSort(long[] a, int l, int r){
        while(l<r){
            int i=l, j=r;
            long p=a[l + ((r-l)>>1)];
            while(i<=j){
                while(a[i]<p) i++;
                while(a[j]>p) j--;
                if(i<=j){
                    long t=a[i]; a[i]=a[j]; a[j]=t;
                    i++; j--;
                }
            }
            if(j-l < r-i){ if(l<j) quickSort(a,l,j); l=i; }
            else { if(i<r) quickSort(a,i,r); r=j; }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = nextSign();
        long[] a = new long[n];
        for(int i=0;i<n;i++) a[i]=nextLong();
        quickSort(a,0,n-1);
        long min = Long.MAX_VALUE;
        for(int i=1;i<n;i++){
            long d = a[i]-a[i-1];
            if(d<min) min=d;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<n;i++){
            if(a[i]-a[i-1]==min){
                if(sb.length()>0) sb.append(' ');
                sb.append(a[i-1]).append(' ').append(a[i]);
            }
        }
        System.out.print(sb.toString());
    }
}