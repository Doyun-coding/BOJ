import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[][] arr;
    static int[][] dp;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1][4];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
            }
        }

        for(int t = 1; t <= 3; t++) {
            dp = new int[N+1][4];

            for(int i = 1; i <= 3; i++) {
                if(i == t) {
                    dp[1][i] = arr[1][i];
                    dp[2][i] = Integer.MAX_VALUE;
                }
                else {
                    dp[1][i] = Integer.MAX_VALUE;
                }
            }

            for(int i = 1; i <= 3; i++) {
                if(i != t) {
                    dp[2][i] = arr[1][t] + arr[2][i];
                }
            }

            for(int i = 3; i < N; i++) {
                for(int j = 1; j <= 3; j++) {
                    if(j == 1) {
                        int m = Math.min(dp[i-1][2], dp[i-1][3]);
                        dp[i][1] = arr[i][1] + m;
                    }
                    else if(j == 2) {
                        int m = Math.min(dp[i-1][1], dp[i-1][3]);
                        dp[i][2] = arr[i][2] + m;
                    }
                    else if(j == 3) {
                        int m = Math.min(dp[i-1][1], dp[i-1][2]);
                        dp[i][3] = arr[i][3] + m;
                    }
                }
            }

            dp[N][t] = Integer.MAX_VALUE;
            for(int i = 1; i <= 3; i++) {
                if(i != t) {
                    if(i == 1) {
                        int m = Math.min(dp[N-1][2], dp[N-1][3]);
                        dp[N][1] = arr[N][1] + m;
                    }
                    else if(i == 2) {
                        int m = Math.min(dp[N-1][1], dp[N-1][3]);
                        dp[N][2] = arr[N][2] + m;
                    }
                    else if(i == 3) {
                        int m = Math.min(dp[N-1][1], dp[N-1][2]);
                        dp[N][3] = arr[N][3] + m;
                    }
                }
            }

            for(int i = 1; i <= 3; i++) {
                min = Math.min(dp[N][i], min);
            }
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}
