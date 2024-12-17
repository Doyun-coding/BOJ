import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            if(N/2 <= 0) break;

            n = N / 2;
            m = N / 2;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {

                    int[] v = new int[4];
                    int idx = 0;
                    for(int a = i*2; a < i*2+2; a++) {
                        for(int b = j*2; b < j*2+2; b++) {
                            v[idx] = arr[a][b];
                            idx++;
                        }
                    }

                    Arrays.sort(v);

                    arr[i][j] = v[2];
                }
            }
            N /= 2;
        }

        bw.write(arr[0][0] + "\n");

        bw.flush();
        bw.close();
    }
}
