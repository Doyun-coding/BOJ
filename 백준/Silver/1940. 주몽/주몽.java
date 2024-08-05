import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static long M;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Long.parseLong(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++) {
            for(int j = i+1; j <= N; j++) {
                if(arr[i] + arr[j] == M) cnt++;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
