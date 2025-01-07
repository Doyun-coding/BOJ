import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int K;
    static Node[] dp;

    static class Node {
        int R;
        int B;
        Node(int R, int B) {
            this.R = R;
            this.B = B;
        }

        int getR() {
            return this.R;
        }
        int getB() {
            return this.B;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        dp = new Node[K+1];

        dp[0] = new Node(1, 0);
        dp[1] = new Node(0, 1);

        for(int i = 2; i <= K; i++) {
            Node node = dp[i-1];
            int r = node.getR();
            int b = node.getB();

            dp[i] = new Node(b, r+b);
        }

        bw.write(dp[K].getR() + " " + dp[K].getB() + "\n");
        bw.flush();
        bw.close();
    }
}
