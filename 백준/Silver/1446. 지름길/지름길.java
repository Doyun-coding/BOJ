import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, D;
    static int[] arr;
    static PriorityQueue<Node> priorityQueue;

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int d;
        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
        int getD() {
            return this.d;
        }


        @Override
        public int compareTo(Node o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[D+1];
        for(int i = 0; i <= D; i++) {
            arr[i] = i;
        }
        priorityQueue = new PriorityQueue<>();

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            priorityQueue.add(new Node(x, y, d));
        }

        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            int x = node.getX();
            int y = node.getY();
            int d = node.getD();

            if(y <= D) {
                if (arr[y] > arr[x] + d) {
                    arr[y] = arr[x] + d;
                    int now = y + 1;
                    while (true) {
                        if (now > D) break;

                        if (arr[now] <= arr[now - 1] + 1) break;

                        arr[now] = arr[now - 1] + 1;
                        now++;
                    }

                }
            }
        }

        bw.write(arr[D] + "\n");
        bw.flush();
        bw.close();
    }
}
