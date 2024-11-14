import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static String S;
    static int zero = 0;
    static int one = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        S = st.nextToken();
        sb = new StringBuilder();

        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '0') {
                zero++;
            }
            else {
                one++;
            }
        }

        zero /= 2;
        one /= 2;

        int cnt = 0;
        for(int i = 0; i < S.length(); i++) {
            if(cnt >= one) {
                sb.append(String.valueOf(S.charAt(i)));
                continue;
            }

            if(S.charAt(i) == '1') {
                cnt++;
                sb.append("2");
            }
            else {
                sb.append(String.valueOf(S.charAt(i)));
            }
        }

        cnt = 0;
        for(int i = S.length()-1; i > 0; i--) {
            if(cnt >= zero) break;

            if(S.charAt(i) == '0') {
                cnt++;
                sb.replace(i, i+1,"2");
            }
        }

        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) != '2') {
                System.out.print(String.valueOf(sb.charAt(i)) + "");
            }
        }
        System.out.println();

    }
}
