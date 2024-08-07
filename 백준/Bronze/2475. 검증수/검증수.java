import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 5; i++) {
            int n = Integer.parseInt(st.nextToken());
            sum += n * n;
            sum %= 10;
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
