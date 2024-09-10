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
        arr = new int[N+1];

        for(int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        for(int i = 1; i <= N; i++) {
            bw.write(arr[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
