import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            int A = Integer.parseInt(String.valueOf(S.charAt(0)));
            int B = Integer.parseInt(String.valueOf(S.charAt(2)));
            int C = A + B;
            bw.write(C + "\n");
        }
        bw.flush();
        bw.close();
    }
}
