import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, K;
    static PriorityQueue<Node> priorityQueue;
    static int cnt = 0;

    static class Node implements Comparable<Node> {
        int n;
        int x;
        int y;
        int z;
        Node(int n,int x, int y, int z) {
            this.n = n;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        int getN() {
            return this.n;
        }
        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
        int getZ() {
            return this.z;
        }

        @Override
        public int compareTo(Node o) {
            if(this.x == o.x) {
                if(this.y == o.y) {
                    return this.z - o.z;
                }
                else {
                    return this.y - o.y;
                }
            }
            else {
                return this.x - o.x;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        priorityQueue = new PriorityQueue<>();

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                priorityQueue.add(new Node(n, x, y, z));

        }

        int preX = -1;
        int preY = -1;
        int preZ = -1;
        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            int x = node.getX();
            int y = node.getY();
            int z = node.getZ();

            if(x != preX || y != preY || z != preZ) {
                cnt++;
            }

            if(node.getN() == K) {
                break;
            }

            preX = x;
            preY = y;
            preZ = z;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
