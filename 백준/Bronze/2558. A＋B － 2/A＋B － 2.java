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
        A = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        A = A + B;
        bw.write(A + "\n");
        bw.flush();
        bw.close();
    }

}