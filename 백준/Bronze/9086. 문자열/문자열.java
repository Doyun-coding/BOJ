import java.io.*;
import java.util.*;

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
            bw.write(S.charAt(0) + "" + S.charAt(S.length()-1) + "\n");

        }
        bw.flush();
        bw.close();
    }

}