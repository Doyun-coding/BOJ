import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[] arr;
    static int[] dec;
    static int len = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        dec = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }

        dec[1] = 1;
        for(int i = 2; i <= N; i++) {
            int m = 0;
            for(int j = 1; j < i; j++) {
                if(arr[i] < arr[j]) {
                    m = Math.max(m, dec[j]);
                }
            }
            dec[i] = m+1;
        }
        for(int i = 1; i <= N; i++) {
            len = Math.max(len, dec[i]);
        }
        bw.write(len + "\n");
        bw.flush();
        bw.close();
    }
}
