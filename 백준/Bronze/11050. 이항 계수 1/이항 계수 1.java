import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N, K;
    static int n = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = N-K+1; i <= N; i++) {
            n *= i;
        }

        for(int i = 1; i <= K; i++) {
            n /= i;
        }
        bw.write(n + "\n");
        bw.flush();
        bw.close();
    }
}