import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int K, N;
    static long[] arr;
    static long max = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[N+1];

        int m = 0;
        int index = 0;
        for(int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            if(n > m) {
                m = n;
                index = i;
            }
        }

        long left = 0;
        long right = arr[index];
        while(true) {
            if(left > right) {
                break;
            }

            cnt = 0;

            long mid = (left + right) / 2;

            if(mid == 0) mid = 1;

            for(int i = 1; i <= N; i++) {
                long n = arr[i] / mid;
                cnt += n;
            }

            if(cnt >= N) {
                max = Math.max(max, mid);
                left = mid+1;
            }
            else {
                right = mid-1;
            }

        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
