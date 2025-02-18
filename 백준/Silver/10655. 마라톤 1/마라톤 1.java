import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static Node[] point;
    static long[] dp;
    static long min = Long.MAX_VALUE;

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        point = new Node[N+1];
        dp = new long[N+1];
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            point[i] = new Node(x, y);
        }

        int x = point[1].getX();
        int y = point[1].getY();
        for(int i = 2; i <= N; i++) {
            Node node = point[i];
            dp[i] = dp[i-1] + Math.abs(x-node.getX()) + Math.abs(y-node.getY());
            x = node.getX();
            y = node.getY();
        }

        for(int i = 2; i < N; i++) {
            long sum = dp[i-1] + dp[N] - dp[i+1];
            Node n1 = point[i-1];
            Node n2 = point[i+1];

            sum += Math.abs(n1.getX()-n2.getX()) + Math.abs(n1.getY()-n2.getY());
            min = Math.min(min, sum);
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}
