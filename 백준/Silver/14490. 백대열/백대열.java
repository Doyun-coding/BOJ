import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static String n = "";
    static String m = "";
    static int ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ':') {
                for(int j = i+1; j < s.length(); j++) {
                    m += String.valueOf(s.charAt(j));
                }
                break;
            }
            else {
                n += String.valueOf(s.charAt(i));
            }
        }

        N = Integer.parseInt(String.valueOf(n));
        M = Integer.parseInt(String.valueOf(m));

        if(N >= M) {
            for(int i = M; i >= 1; i--) {
                if(M % i == 0 && N % i == 0) {
                    ans = i;
                    break;
                }
            }
        }
        else {
            for(int i = N; i >= 1; i--) {
                if(N % i == 0 && M % i == 0) {
                    ans = i;
                    break;
                }
            }
        }

        N /= ans;
        M /= ans;

        bw.write(N + ":" + M + "\n");
        bw.flush();
        bw.close();
    }
}
