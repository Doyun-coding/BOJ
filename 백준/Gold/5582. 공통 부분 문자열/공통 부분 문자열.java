import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static String S1, S2;
    static int len = 0;
    static int max = 0;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        S1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        S2 = st.nextToken();

        dp = new int[S1.length()+1][S2.length()+1];
        for(int i = 0; i <= S1.length(); i++) {
            for(int j = 0; j <= S2.length(); j++) {
                dp[i][j] = 0;
            }
        }

        for(int i = 1; i <= S1.length(); i++) {
            for(int j = 1; j <= S2.length(); j++) {
                if(S1.charAt(i-1) == S2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
