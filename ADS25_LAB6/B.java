import java.io.*;

public class B {
    static final BufferedInputStream in = new BufferedInputStream(System.in);
    static int read() throws IOException { return in.read(); }
    static boolean sp(int c){ return c<=32; }
    static int nextInt() throws IOException {
        int c; do c = read(); while (sp(c));
        int s = 1; if (c=='-'){ s=-1; c=read(); }
        int x = 0; while (c>32){ x = x*10 + c-'0'; c = read(); }
        return x*s;
    }

    static void quickSort(int[] a, int l, int r){
        while(l<r){
            int i=l, j=r, p=a[l+(r-l)/2];
            while(i<=j){
                while(a[i]<p) i++;
                while(a[j]>p) j--;
                if(i<=j){
                    int t=a[i]; a[i]=a[j]; a[j]=t;
                    i++; j--;
                }
            }
            if(j-l<r-i){ if(l<j) quickSort(a,l,j); l=i; }
            else { if(i<r) quickSort(a,i,r); r=j; }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt(), m = nextInt();
        int[] a = new int[n], b = new int[m];
        for(int i=0;i<n;i++) a[i]=nextInt();
        for(int i=0;i<m;i++) b[i]=nextInt();
        quickSort(a,0,n-1);
        quickSort(b,0,m-1);
        int i=0,j=0;
        StringBuilder sb=new StringBuilder();
        while(i<n && j<m){
            if(a[i]==b[j]){
                if(sb.length()>0) sb.append(' ');
                sb.append(a[i]);
                i++; j++;
            } else if(a[i]<b[j]) i++;
            else j++;
        }
        System.out.print(sb.toString());
    }
}