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
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= N; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        bw.write(arr[N] + "\n");
        bw.flush();
        bw.close();
    }
}
