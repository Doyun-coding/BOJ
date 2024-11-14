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

//        sb = new StringBuilder();
//        for(int i = 0)

        sb = new StringBuilder();
        for(int i = 0; i < zero; i++) {
            sb.append("0");
        }

        for(int i = 0; i < one; i++) {
            sb.append("1");
        }

        bw.write(sb.toString() + "\n");

        bw.flush();
        bw.close();
    }
}
