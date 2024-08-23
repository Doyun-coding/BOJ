import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        String aMin = "";
        String aMax = "";
        for(int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if(c == '6') {
                String s = "5";
                aMin += s;
                s = "6";
                aMax += s;
            }
            else if(c == '5') {
                String s = "5";
                aMin += s;
                s = "6";
                aMax += s;
            }
            else {
                String s = String.valueOf(c);
                aMin += s;
                aMax += s;
            }

        }

        int min = Integer.parseInt(aMin);
        int max = Integer.parseInt(aMax);

        String bMin = "";
        String bMax = "";

        for(int i = 0; i < B.length(); i++) {
            char c = B.charAt(i);
            if(c == '5') {
                String s = "5";
                bMin += s;
                s = "6";
                bMax += s;
            }
            else if(c == '6') {
                String s = "5";
                bMin += s;
                s = "6";
                bMax += s;
            }
            else {
                String s = String.valueOf(c);
                bMin += s;
                bMax += s;
            }

        }

        min += Integer.parseInt(bMin);
        max += Integer.parseInt(bMax);

        bw.write(min + " " + max);
        bw.flush();
        bw.close();
    }

}