import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[][] dp;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[5][M+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            for(int j = 1; j <= M; j++) {
                if(S.charAt(j-1) == 'A') {
                    dp[1][j] += 1;
                }
                else if(S.charAt(j-1) == 'C') {
                    dp[2][j] += 1;
                }
                else if(S.charAt(j-1) == 'G') {
                    dp[3][j] += 1;
                }
                else if(S.charAt(j-1) == 'T') {
                    dp[4][j] += 1;
                }
            }
        }

        for(int i = 1; i <= M; i++) {
            int max = 0;
            for(int j = 1; j <= 4; j++) {
                max = Math.max(dp[j][i], max);
            }

            dp[0][i] = max;
        }

        String s = "";

        for(int i = 1; i <= M; i++) {
            int max = dp[0][i];
            int index = 0;
            for(int j = 1; j <= 4; j++) {
                if(max == dp[j][i]) {
                    index = j;
                    if(j == 1) s += "A";
                    else if(j == 2) s += "C";
                    else if(j == 3) s += "G";
                    else if(j == 4) s += "T";

                    break;
                }
            }
            for(int j = 1; j <= 4; j++) {
                if(j != index) {
                    cnt += dp[j][i];
                }
            }
        }

        bw.write(s + "\n");
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
