import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static Long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        if(N == 0) {
            System.out.println("0");
        }
        else if(N == 1) {
            System.out.println("1");
        }
        else {
            BigInteger bigInteger2 = BigInteger.ZERO;
            BigInteger bigInteger1 = BigInteger.ONE;
            BigInteger bigTemp;
            for(int i = 2; i <= N; i++) {
                bigTemp = bigInteger1.add(bigInteger2);
                bigInteger2 = bigInteger1;
                bigInteger1 = bigTemp;
            }
            System.out.println(bigInteger1);
        }
    }
}
