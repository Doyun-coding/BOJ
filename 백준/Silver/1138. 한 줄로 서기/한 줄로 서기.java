import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for(int j = 1; j <= N; j++) {
                if(cnt == n && arr[j] == 0) {
                    arr[j] = i;
                    break;
                }

                if(arr[j] == 0) {
                    cnt++;
                }
            }

        }

        for(int i = 1; i <= N; i++) {
            bw.write(arr[i] + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
    }
}
