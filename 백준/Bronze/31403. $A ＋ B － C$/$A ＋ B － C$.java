import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static String A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        st = new StringTokenizer(br.readLine());
        B = st.nextToken();
        st = new StringTokenizer(br.readLine());
        C = st.nextToken();
        int n = Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C);
        bw.write(n + "\n");
        String s = A + B;
        n = Integer.parseInt(s) - Integer.parseInt(C);
        bw.write(n + "\n");
        bw.flush();
        bw.close();
    }
}
