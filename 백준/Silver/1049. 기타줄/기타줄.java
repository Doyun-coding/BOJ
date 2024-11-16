import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int set = Integer.MAX_VALUE;
    static int one = Integer.MAX_VALUE;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            set = Math.min(set, n);
            one = Math.min(one, m);
        }

        if(one * 6 <= set) {
            sum += one * N;
        }
        else {
            int cnt = N / 6;
            sum += cnt * set;

            cnt = N % 6;
            int c = Math.min(set, cnt * one);
            sum += c;
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
    }
}
