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

        if(S.equals("A+")) {
            bw.write("4.3\n");
        }
        else if(S.equals("A0")) {
            bw.write("4.0\n");
        }
        else if(S.equals("A-")) {
            bw.write("3.7\n");
        }
        else if(S.equals("B+")) {
            bw.write("3.3\n");
        }
        else if(S.equals("B0")) {
            bw.write("3.0\n");
        }
        else if(S.equals("B-")) {
            bw.write("2.7\n");
        }
        else if(S.equals("C+")) {
            bw.write("2.3\n");
        }
        else if(S.equals("C0")) {
            bw.write("2.0\n");
        }
        else if(S.equals("C-")) {
            bw.write("1.7\n");
        }
        else if(S.equals("D+")) {
            bw.write("1.3\n");
        }
        else if(S.equals("D0")) {
            bw.write("1.0\n");
        }
        else if(S.equals("D-")) {
            bw.write("0.7\n");
        }
        else {
            bw.write("0.0\n");
        }

        bw.flush();
        bw.close();
    }

}