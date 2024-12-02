import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int T;
    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[3][N+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                arr[2][i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[3][N+1];

            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];

            if(N == 1) {
                int ans = Math.max(dp[1][1], dp[2][1]);
                bw.write(ans + "\n");
                continue;
            }

            dp[1][2] = dp[2][1] + arr[1][2];
            dp[2][2] = dp[1][1] + arr[2][2];

            for(int i = 3; i <= N; i++) {
                dp[1][i] = Math.max(dp[2][i-1]+arr[1][i], Math.max(dp[1][i-2]+arr[1][i], dp[2][i-2]+arr[1][i]));
                dp[2][i] = Math.max(dp[1][i-1]+arr[2][i], Math.max(dp[1][i-2]+arr[2][i], dp[2][i-2]+arr[2][i]));
            }

            int ans = Math.max(dp[1][N], dp[2][N]);

            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}
