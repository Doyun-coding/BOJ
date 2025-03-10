import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static Node[] nodes;
    static double max = 0;

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

    static void triangle(int a, int b, int c) {
        double d = nodes[a].x*nodes[b].y + nodes[b].x*nodes[c].y + nodes[c].x*nodes[a].y;
        d -= (nodes[a].y*nodes[b].x + nodes[b].y*nodes[c].x + nodes[c].y*nodes[a].x);

        d = Math.abs(d) * 0.5;
        max = Math.max(max, d);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nodes = new Node[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(x, y);
        }

        for(int i = 1; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                for(int k = j+1; k <= N; k++) {
                    triangle(i, j, k);
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
