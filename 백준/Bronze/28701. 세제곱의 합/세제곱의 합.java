import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            sum += i;
        }

        bw.write(sum + "\n");
        bw.write((long)Math.pow(sum, 2) + "\n");

        sum = 0;
        for(int i = 1; i <= N; i++) {
            sum += Math.pow(i, 3);
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
    }
}
