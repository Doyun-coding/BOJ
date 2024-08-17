import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static boolean check = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        int length = s.length();
        N = Integer.parseInt(s);
        int n = Integer.parseInt(s);

        int m = 10 * length;
        n -= m;

        if(n <= 0) {
            n = 1;
        }

        for(int i = n; i <= N; i++) {
            String S = String.valueOf(i);
            int sum = i;

            for(int j = 0; j < S.length(); j++) {
                sum += Integer.parseInt(String.valueOf(S.charAt(j)));
            }

            if(sum == N) {
                bw.write(i + "\n");
                check = false;
                break;
            }
        }

        if(check) {
            bw.write("0\n");
        }

        bw.flush();
        bw.close();

    }
}