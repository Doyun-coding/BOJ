import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N != 0) {
            arr = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i] = n;
            }

            int m = 0;
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (m + arr[i] <= M) {
                    m += arr[i];
                } else {
                    cnt += 1;
                    m = arr[i];
                }
            }

            if (m != 0) {
                cnt += 1;
            }

            bw.write(cnt + "\n");
        }
        else {
            bw.write("0\n");
        }

        bw.flush();
        bw.close();
    }
}
