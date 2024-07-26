import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        char c = S.charAt(0);
        int n = (int) c;
        System.out.println(n);
    }
}
