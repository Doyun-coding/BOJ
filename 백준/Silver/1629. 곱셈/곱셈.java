import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static long A, B, C;

    static long cal(long a, long b, long c) {
        if(b == 1) {
            return a % c;
        }

        long n = cal(a, b / 2, c);
        if(b % 2 == 1) {
            return (n * n % c) * a % c;
        }

        return n * n % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        long l = cal(A, B, C);
        System.out.println(l);
    }
}
