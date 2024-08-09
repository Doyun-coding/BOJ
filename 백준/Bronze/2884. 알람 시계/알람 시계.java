import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        M -= 45;
        if(M < 0) {
            N -= 1;
            M += 60;
            if(N < 0) {
                bw.write("23 " + M);
            }
            else {
                bw.write(N + " " + M);
            }
        }
        else {
            bw.write(N + " " + M);
        }
        bw.flush();
        bw.close();
    }
}
