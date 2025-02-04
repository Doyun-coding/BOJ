import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[] station;
    static int[][] arr;
    static PriorityQueue<Node> priorityQueue;
    static boolean[] visited;
    static int minChange = 1001;
    static int minCost = 1000001;

    static class Node implements Comparable<Node> {
        int x;
        int change;
        int cost;
        Node(int x, int change, int cost) {
            this.x = x;
            this.change = change;
            this.cost = cost;
        }
        int getX() {
            return this.x;
        }
        int getChange() {
            return this.change;
        }
        int getCost() {
            return this.cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.change == o.change) {
                return this.cost - o.cost;
            }
            return this.change - o.change;
        }
    }

    static void Dijkstra(int x) {
        priorityQueue.add(new Node(x, 0, 0));

        while(!priorityQueue.isEmpty()) {
            Node curNode = priorityQueue.remove();
            int u = curNode.getX();
            int change = curNode.getChange();
            int cost = curNode.getCost();

            if(u == M) {
                minChange = Math.min(minChange, change);
                minCost = Math.min(minCost, cost);
            }

            if(cost <= minChange) {
                if(!visited[u]) {
                    visited[u] = true;
                    for (int i = 0; i < N; i++) {
                        if (arr[u][i] != 0 && !visited[i]) {
                            if (station[u] == station[i]) {
                                priorityQueue.add(new Node(i, change, cost + arr[u][i]));
                            } else {
                                priorityQueue.add(new Node(i, change + 1, cost + arr[u][i]));
                            }
                        }
                    }
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        station = new int[N];
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            station[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        priorityQueue = new PriorityQueue<>();
        visited = new boolean[N];
        Dijkstra(0);

        bw.write(minChange + " " + minCost + "\n");
        bw.flush();
        bw.close();
    }
}
