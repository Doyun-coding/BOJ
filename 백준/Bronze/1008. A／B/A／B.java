import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static double A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        double ans = A / B;
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
