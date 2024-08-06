import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static String S;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        bw.write(S.charAt(N-1) + "\n");
        bw.flush();
        bw.close();
    }
}
