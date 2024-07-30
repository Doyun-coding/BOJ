import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[][] dp;
    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N+1][10];
        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
            for(int j = 1; j <= 8; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                dp[i][j] %= 1000000000;
            }
        }

        for(int i = 0; i <= 9; i++) {
            sum += dp[N][i];
            sum %= 1000000000;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
