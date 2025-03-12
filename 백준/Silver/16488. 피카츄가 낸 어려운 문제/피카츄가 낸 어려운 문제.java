import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static long N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long n = N*N*K;

        bw.write(n + "\n");
        bw.flush();
        bw.close();
    }
}
