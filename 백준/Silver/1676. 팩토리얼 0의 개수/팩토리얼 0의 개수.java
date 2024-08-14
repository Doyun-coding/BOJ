import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static long n = 1;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i = 2; i <= N; i++) {
            n *= i;
            while(true) {
                if(n % 10 != 0) break;
                cnt++;

                n /= 10;
            }
            n %= 10000000;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
