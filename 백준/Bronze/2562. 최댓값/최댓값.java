import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int index = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int t = 1; t <= 9; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n > max) {
                max = n;
                index = t;
            }
        }
        bw.write(max + "\n");
        bw.write(index + "\n");
        bw.flush();
        bw.close();
    }
}
