import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int L;
    static long ans = 0;
    static long pow = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String S = st.nextToken();

        for(int i = 1; i <= L; i++) {

            ans += ((S.charAt(i-1) - 96) * pow);
            pow = (pow * 31) % 1234567891;
        }

        bw.write(ans % 1234567891 + "\n");
        bw.flush();
        bw.close();
    }

}