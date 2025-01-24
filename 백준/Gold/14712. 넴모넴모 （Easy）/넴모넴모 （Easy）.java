import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[][] arr;
    static int cnt = 0;

    static void BackTracking(int n, int m) {
        if(n > N) {
            boolean check = true;
            for(int i = 1; i < N; i++) {
                for(int j = 1; j < M; j++) {
                    if(arr[i][j] == 1 && arr[i+1][j] == 1 && arr[i][j+1] == 1 && arr[i+1][j+1] == 1) {
                        check = false;
                        break;
                    }

                    if(!check) break;

                }
            }

            if(check) cnt++;

            return;
        }

        for(int j = m; j <= M; j++) {
            arr[n][j] = 1;
            BackTracking(n, j+1);
            arr[n][j] = 0;
        }

        BackTracking(n+1, 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];

        BackTracking(1, 1);

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
