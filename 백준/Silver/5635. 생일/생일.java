import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static PriorityQueue<Node> priorityQueue;

    static class Node implements Comparable<Node> {
        String name;
        int d;
        int m;
        int y;
        Node(String name, int d, int m, int y) {
            this.name = name;
            this.d = d;
            this.m = m;
            this.y = y;
        }
        String getName() {
            return this.name;
        }
        int getD() {
            return this.d;
        }
        int getM() {
            return this.m;
        }
        int getY() {
            return this.y;
        }

        @Override
        public int compareTo(Node o) {
            if(this.y == o.y) {
                if(this.m == o.m) {
                    return o.d - this.d;
                }
                else {
                    return o.m - this.m;
                }
            }
            else {
                return o.y - this.y;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        priorityQueue = new PriorityQueue<>();

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            priorityQueue.add(new Node(S, d, m, y));
        }

        if(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            bw.write(node.getName() + "\n");
        }

        String name = "";
        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            name = node.getName();
        }
        bw.write(name + "\n");
        bw.flush();
        bw.close();
    }
}
