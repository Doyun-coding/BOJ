import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        S = st.nextToken();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c >= 97) {
                c -= 32;
                String s = String.valueOf(c);
                sb.append(s + "");
            }
            else {
                c += 32;
                String s = String.valueOf(c);
                sb.append(s + "");
            }
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }


}