import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static String S = "666";
    static int cnt = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        int n = 0;

        while(true) {
            if(cnt == N) break;

            n++;

            if(String.valueOf(n).contains(S)) {
                cnt++;
                if(cnt == N) {
                    sb.append(n + "\n");
                    break;
                }
            }
        }

        bw.write(sb.toString() + "");
        bw.flush();
        bw.close();
    }

}
