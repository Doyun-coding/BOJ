import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, K;
    static int cnt = 0;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            if(N % i == 0) {
                cnt++;
                if(cnt == K) {
                    ans = i;
                    break;
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
