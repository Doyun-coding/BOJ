import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        for(int p = 1; p <= P; p++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for(int i = 0; i < s.length(); i++) {
                for(int j = 1; j <= n; j++) {
                    bw.write(String.valueOf(s.charAt(i)) + "");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
