import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int ans1 = (int) (N * 0.78);
        int ans2 = (int) (N - ((N * 0.2) * 0.22));

        bw.write(ans1 + " ");
        bw.write(ans2 + "\n");
        bw.flush();
        bw.close();
    }
}
