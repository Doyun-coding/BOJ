import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, L, R, X;
    static long[] arr;
    static int cnt = 0;

    static void BackTracking(long[] sum, int depth) {
        if(depth > N) {
            //System.out.println(sum[0]);
            if(sum[2] - sum[1] >= X) {
                if(sum[0] >= L && sum[0] <= R) {
                    cnt++;
                }
            }

            return;
        }

        for(int i = depth; i <= N; i++) {
            sum[0] += arr[i];
            long min = sum[1];
            long max = sum[2];
            sum[1] = Math.min(sum[1], arr[i]);
            sum[2] = Math.max(sum[2], arr[i]);
            BackTracking(sum, i+1);
            sum[0] -= arr[i];
            sum[1] = min;
            sum[2] = max;
        }
        BackTracking(sum, N+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] sum = new long[3];
        sum[1] = Integer.MAX_VALUE;
        BackTracking(sum, 1);

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
