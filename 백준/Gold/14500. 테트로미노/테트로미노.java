import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[][] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 4; j <= M; j++) {
                int sum = arr[i][j-3] + arr[i][j-2] + arr[i][j-1] + arr[i][j];

                max = Math.max(max, sum);
            }
        }

        for(int i = 4; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                int sum = arr[i-3][j] + arr[i-2][j] + arr[i-1][j] + arr[i][j];

                max = Math.max(max, sum);
            }
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 2; j <= M; j++) {
                int sum = 0;
                sum = arr[i-1][j-1] + arr[i][j-1] + arr[i-1][j] + arr[i][j];

                max = Math.max(max, sum);
            }
        }

        for(int i = 3; i <= N; i++) {
            for(int j = 2; j <= M; j++) {
                int sum1 = arr[i-2][j-1] + arr[i-1][j-1] + arr[i][j-1] + arr[i][j];
                int sum2 = arr[i-2][j-1] + arr[i-2][j] + arr[i-1][j] + arr[i][j];

                max = Math.max(max, Math.max(sum1, sum2));

                sum1 = arr[i-2][j] + arr[i-1][j] + arr[i][j] + arr[i][j-1];
                sum2 = arr[i-2][j] + arr[i-2][j-1] + arr[i-1][j-1] + arr[i][j-1];

                max = Math.max(max, Math.max(sum1, sum2));
            }
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 3; j <= M; j++) {
                int sum1 = arr[i-1][j] + arr[i][j-2] + arr[i][j-1] + arr[i][j];
                int sum2 = arr[i][j-2] + arr[i-1][j-2] + arr[i-1][j-1] + arr[i-1][j];

                max = Math.max(max, Math.max(sum1, sum2));

                sum1 = arr[i-1][j-2] + arr[i][j-2] + arr[i][j-1] + arr[i][j];
                sum2 = arr[i-1][j] + arr[i][j] + arr[i-1][j-1] + arr[i-1][j-2];

                max = Math.max(max, Math.max(sum1, sum2));
            }
        }

        for(int i = 3; i <= N; i++) {
            for(int j = 2; j <= M; j++) {
                int sum1 = arr[i-2][j-1] + arr[i-1][j-1] + arr[i-1][j] + arr[i][j];
                int sum2 = arr[i-2][j] + arr[i-1][j] + arr[i-1][j-1] + arr[i][j-1];

                max = Math.max(max, Math.max(sum1, sum2));
            }
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 3; j <= M; j++) {
                int sum1 = arr[i][j-2] + arr[i][j-1] + arr[i-1][j-1] + arr[i-1][j];
                int sum2 = arr[i-1][j-2] + arr[i-1][j-1] + arr[i][j-1] + arr[i][j];

                max = Math.max(max, Math.max(sum1, sum2));
            }
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 3; j <= M; j++) {
                int sum1 = arr[i-1][j-1] + arr[i][j-2] + arr[i][j-1] + arr[i][j];
                int sum2 = arr[i-1][j-2] + arr[i-1][j-1] + arr[i-1][j] + arr[i][j-1];

                max = Math.max(max, Math.max(sum1, sum2));
            }
        }

        for(int i = 3; i <= N; i++) {
            for(int j = 2; j <= M; j++) {
                int sum1 = arr[i-2][j-1] + arr[i-1][j-1] + arr[i-1][j] + arr[i][j-1];
                int sum2 = arr[i-1][j-1] + arr[i-2][j] + arr[i-1][j] + arr[i][j];

                max = Math.max(max, Math.max(sum1, sum2));
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
