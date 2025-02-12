import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, P;
    static int[][] capacity;
    static int[][] flow;
    static int[] parent;
    static int source, sink;
    static Queue<Integer> queue;
    static int totalAmount = 0;

    static void networkFlow() {

        while(true) {
            queue = new LinkedList<>();
            Arrays.fill(parent, -1);
            parent[source] = source;
            queue.add(source);

            while(!queue.isEmpty() && parent[sink] == -1) {
                int u = queue.remove();

                for(int i = 1; i <= N; i++) {
                    if(capacity[u][i] - flow[u][i] > 0 && parent[i] == -1) {
                        queue.add(i);
                        parent[i] = u;
                    }
                }
            }

            if(parent[sink] == -1) break;

            int p = sink;
            int amount = Integer.MAX_VALUE;

            while(p != source) {
                amount = Math.min(amount, capacity[parent[p]][p] - flow[parent[p]][p]);

                p = parent[p];
            }

            p = sink;
            while(p != source) {
                flow[parent[p]][p] += amount;
                flow[p][parent[p]] -= amount;

                p = parent[p];
            }

            totalAmount++;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        capacity = new int[N+1][N+1];
        flow = new int[N+1][N+1];
        parent = new int[N+1];

        for(int i = 1; i <= P; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            capacity[s][e] = 1;
        }

        source = 1;
        sink = 2;

        networkFlow();

        bw.write(totalAmount + "\n");
        bw.flush();
        bw.close();
    }
}
