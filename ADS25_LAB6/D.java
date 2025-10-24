import java.io.*;

public class D {
    static final BufferedInputStream in = new BufferedInputStream(System.in);
    static int read() throws IOException { return in.read(); }
    static boolean isDigit(int c){ return c>='0'&&c<='9'; }
    static int nextInt() throws IOException {
        int c; do c = read(); while (c!=-1 && !isDigit(c));
        int x = 0;
        while (c!=-1 && isDigit(c)) { x = x*10 + c - '0'; c = read(); }
        return x;
    }

    static void quickSort(long[] k, int[] d, int[] m, int[] y, int l, int r){
        while(l<r){
            int i=l, j=r;
            long p=k[l+((r-l)>>1)];
            while(i<=j){
                while(k[i]<p) i++;
                while(k[j]>p) j--;
                if(i<=j){
                    long tk=k[i]; k[i]=k[j]; k[j]=tk;
                    int td=d[i]; d[i]=d[j]; d[j]=td;
                    int tm=m[i]; m[i]=m[j]; m[j]=tm;
                    int ty=y[i]; y[i]=y[j]; y[j]=ty;
                    i++; j--;
                }
            }
            if(j-l<r-i){ if(l<j) quickSort(k,d,m,y,l,j); l=i; }
            else { if(i<r) quickSort(k,d,m,y,i,r); r=j; }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int[] dd = new int[n], mm = new int[n], yy = new int[n];
        long[] key = new long[n];
        for(int i=0;i<n;i++){
            int d = nextInt();
            int m = nextInt();
            int y = nextInt();
            dd[i]=d; mm[i]=m; yy[i]=y;
            key[i] = ((long)y)*10000L + m*100L + d;
        }
        quickSort(key,dd,mm,yy,0,n-1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(i>0) sb.append('\n');
            if(dd[i]<10) sb.append('0'); sb.append(dd[i]).append('-');
            if(mm[i]<10) sb.append('0'); sb.append(mm[i]).append('-');
            if(yy[i]<1000) {
                if(yy[i]<100) sb.append('0');
                if(yy[i]<10) sb.append('0');
                sb.append('0');
            }
            if(yy[i]<1000) {
                String s = String.valueOf(yy[i]);
                for(int z=s.length(); z<4; z++) sb.append('0');
                sb.append(s);
            } else sb.append(yy[i]);
        }
        System.out.print(sb.toString());
    }
}