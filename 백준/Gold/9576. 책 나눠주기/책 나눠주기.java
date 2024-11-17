import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int T;
    static int N, M;
    static boolean[] books;
    static PriorityQueue<Node> priorityQueue;
    static int cnt = 0;

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int w;
        Node(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }

        int getStart() {
            return this.start;
        }
        int getEnd() {
            return this.end;
        }
        int getW() {
            return this.w;
        }

        @Override
        public int compareTo(Node o) {
            if(this.end == o.end) {
                return this.start - o.start;
            }

            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            books = new boolean[N+1];
            priorityQueue = new PriorityQueue<>();

            for(int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int w = end - start + 1;

                priorityQueue.add(new Node(start, end, w));
            }

            cnt = 0;

            while(!priorityQueue.isEmpty()) {
                Node node = priorityQueue.remove();
                int start = node.getStart();
                int end = node.getEnd();
                int w = node.getW();

                for(int i = start; i <= end; i++) {
                    if(!books[i]) {
                        books[i] = true;
                        cnt++;
                        break;
                    }
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
    }
}
