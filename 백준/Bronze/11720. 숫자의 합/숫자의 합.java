import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(String.valueOf(s.charAt(i)));
            sum += n;
        }
        System.out.println(sum);
    }
}
