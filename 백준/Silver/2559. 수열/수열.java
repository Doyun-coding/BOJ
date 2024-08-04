import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, K;
    static int[] arr;
    static long max = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N+1-K; i++) {
            long l = 0;
            for(int j = i; j < i+K; j++) {
                l += arr[j];
            }
            max = Math.max(max, l);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
