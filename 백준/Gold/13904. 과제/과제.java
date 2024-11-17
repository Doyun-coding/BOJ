import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static PriorityQueue<Node> priorityQueue;
    static boolean[] days;
    static int sum = 0;

    static class Node implements Comparable<Node> {
        int d;
        int w;
        Node(int d, int w) {
            this.d = d;
            this.w = w;
        }
        int getD() {
            return this.d;
        }
        int getW() {
            return this.w;
        }

        @Override
        public int compareTo(Node o) {
            if(this.w == o.w) {
                return this.d - o.d;
            }

            return o.w - this.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        priorityQueue = new PriorityQueue<>();
        days = new boolean[1001];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            priorityQueue.add(new Node(d, w));
        }

        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            int d = node.getD();
            int w = node.getW();

            for(int i = d; i >= 1; i--) {
                if(!days[i]) {
                    days[i] = true;
                    sum += w;
                    break;
                }
            }
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
    }
}
