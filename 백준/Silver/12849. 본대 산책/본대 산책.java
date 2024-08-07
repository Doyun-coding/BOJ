import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int D;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        dp = new int[9][D+1];
        dp[1][0] = 1;

        for(int i = 1; i <= D; i++) {
            dp[1][i] = (dp[2][i-1] + dp[3][i-1]) % 1000000007;
            dp[2][i] = (((dp[1][i-1] + dp[3][i-1]) % 1000000007) + dp[4][i-1]) % 1000000007;
            dp[3][i] = ((dp[1][i-1] + dp[2][i-1]) % 1000000007 + (dp[4][i-1] + dp[6][i-1]) % 1000000007) % 1000000007;
            dp[4][i] = ((dp[2][i-1] + dp[3][i-1]) % 1000000007 + (dp[5][i-1] + dp[6][i-1]) % 1000000007) % 1000000007;
            dp[5][i] = (((dp[4][i-1] + dp[6][i-1]) % 1000000007) + dp[7][i-1]) % 1000000007;
            dp[6][i] = ((dp[3][i-1] + dp[4][i-1]) % 1000000007 + (dp[5][i-1] + dp[8][i-1]) % 1000000007) % 1000000007;
            dp[7][i] = (dp[5][i-1] + dp[8][i-1]) % 1000000007;
            dp[8][i] = (dp[6][i-1] + dp[7][i-1]) % 1000000007;
        }

        bw.write(dp[1][D] + "\n");
        bw.flush();
        bw.close();
    }
}
