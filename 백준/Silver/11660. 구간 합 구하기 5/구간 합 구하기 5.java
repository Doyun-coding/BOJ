import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[][] arr;
    static int[][] sumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][];
        for(int i = 0; i <= N; i++) {
            arr[i] = new int[N+1];
        }
        sumArr = new int[N+1][];
        for(int i = 0; i <= N; i++) {
            sumArr[i] = new int[N+1];
        }
        for(int i = 0; i <= N; i++) {
            sumArr[0][i] = 0;
            sumArr[i][0] = 0;
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
                if(i-1 == 0 && j-1 == 0) {
                    sumArr[i][j] = n;
                }
                else if(i-1 == 0) {
                    sumArr[i][j] = sumArr[i][j-1] + arr[i][j];
                }
                else if(j-1 == 0) {
                    sumArr[i][j] = sumArr[i-1][j] + arr[i][j];
                }
                else {
                    sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + arr[i][j];
                }
            }
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            if(x1 == x2 && y1 == y2) {
                sum = arr[x1][y1];
            }
            else {
                sum = sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1];
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}
