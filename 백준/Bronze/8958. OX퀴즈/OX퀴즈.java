import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int sum = 0;
            int now = 0;
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == 'O') {
                    now += 1;
                    sum += now;
                }
                else {
                    now = 0;
                }
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}
