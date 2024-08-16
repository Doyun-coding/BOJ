import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int A, B, V;
    static int now = 0;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        V -= A;

        int division = A - B;
        int count = V / division;

        if(V % division != 0) {
            count++;
        }

        cnt += count;

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}