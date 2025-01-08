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

        int plus = 1;
        int sum = 0;
        while(true) {
            sum += plus;

            if(sum >= N) {
                sum -= plus;
                break;
            }

            plus++;
        }

        if(N == 1) {
            bw.write("1/1\n");
        }
        else {
            if(plus % 2 == 0) {
                int c = N - sum -1;
                int a = 1+c;
                int b = plus-c;
                bw.write(a + "/" + b + "\n");
            }
            else {
                int c = N - sum - 1;
                int a = plus - c;
                int b = 1 + c;
                bw.write(a + "/" + b + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
