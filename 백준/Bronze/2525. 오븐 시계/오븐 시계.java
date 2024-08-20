import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());

        int h = C / 60;
        int m = C % 60;

        A += h;
        B += m;

        if(B >= 60) {
            h = B / 60;
            B = B % 60;
            A += h;
        }

        if(A >= 24) {
            A %= 24;
        }

        bw.write(A + " " + B);
        bw.flush();
        bw.close();
    }


}