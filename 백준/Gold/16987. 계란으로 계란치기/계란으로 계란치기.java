import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static Node[] nodes;
    static int max = 0;

    static void BackTracking(int depth) {
        if(depth == N) {
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                if(nodes[i].getS() <= 0) {
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
            return;
        }

        boolean check = false;
        for(int i = 0; i < N; i++) {
            if(i != depth) {
                if(nodes[i].getS() > 0 && nodes[depth].getS() > 0) {
                    nodes[i].s -= nodes[depth].w;
                    nodes[depth].s -= nodes[i].w;
                    BackTracking(depth+1);
                    nodes[i].s += nodes[depth].w;
                    nodes[depth].s += nodes[i].w;
                    check = true;
                }
            }
        }
        if(!check) {
            BackTracking(depth + 1);
        }
    }

    static class Node {
        int s;
        int w;

        Node(int s, int w) {
            this.s = s;
            this.w = w;
        }

        int getS() {
            return this.s;
        }
        int getW() {
            return this.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nodes = new Node[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(s, w);
        }

        BackTracking(0);

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
