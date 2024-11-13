import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int A, B;
    static int N;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        if(A > B) {
            int n = A - B;
            min = Math.min(min, n);
        }
        else {
            int n = B - A;
            min = Math.min(min, n);
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if(n > B) {
                n = n - B + 1;
            }
            else {
                n = B - n + 1;
            }

            min = Math.min(min, n);

        }

        bw.write(min + "\n");

        bw.flush();
        bw.close();
    }
}
