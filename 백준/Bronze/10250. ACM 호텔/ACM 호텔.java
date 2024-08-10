import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int T;
    static int H, W, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int w = N / H + 1;
            int h = N % H;
            if(h == 0) {
                h = H;
                w--;
            }
            if(w < 10) {
                bw.write(h + "0" + w);
            }
            else {
                bw.write(h + "" + w);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
