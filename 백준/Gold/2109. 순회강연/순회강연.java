import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static PriorityQueue<Node> priorityQueue;
    static boolean[] days;
    static long sum = 0;

    static class Node implements Comparable<Node> {
        int p;
        int d;
        Node(int p, int d) {
            this.d = d;
            this.p = p;
        }
        int getD() {
            return this.d;
        }
        int getP() {
            return this.p;
        }

        @Override
        public int compareTo(Node o) {
            if(this.p == o.p) {
                return this.d - o.d;
            }

            return o.p - this.p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        priorityQueue = new PriorityQueue<>();
        days = new boolean[100001];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            priorityQueue.add(new Node(p, d));
        }

        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            int d = node.getD();
            int p = node.getP();

            for(int i = d; i >= 1; i--) {
                if(!days[i]) {
                    days[i] = true;
                    sum += p;
                    break;
                }
            }
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
    }
}
