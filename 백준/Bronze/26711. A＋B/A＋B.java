import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        BigInteger a = new BigInteger(st.nextToken());
        st = new StringTokenizer(br.readLine());
        BigInteger b = new BigInteger(st.nextToken());

        System.out.println(a.add(b));

    }
}
