import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int T;
    static int A = 300;
    static int B = 60;
    static int C = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        int a = T / A;
        T = T % A;
        int b = T / B;
        T = T % B;
        int c = T / C;
        T = T % C;

        if(T != 0) {
            bw.write("-1\n");
        }
        else {
            bw.write(a + " " + b + " " + c + "\n");
        }
        bw.flush();
        bw.close();
    }
}
