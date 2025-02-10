import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[][] arr;
    static PriorityQueue<Node> priorityQueue;
    static boolean[][] visited;
    static int[][] dist;
    static int ans = -1;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
        int getCost() {
            return this.cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

    }

    static void Dijkstra(int a, int b) {
        for(int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        priorityQueue.add(new Node(a, b, arr[a][b]));

        while(!priorityQueue.isEmpty()) {
            Node curNode = priorityQueue.remove();
            int x = curNode.getX();
            int y = curNode.getY();
            int cost = curNode.getCost();

            if(x == N && y == M) {
                ans = cost;
                return;
            }

            if(!visited[x][y]) {
                visited[x][y] = true;

                for(int i = 0; i < 4; i++) {
                    if(x+dx[i] >= 1 && x+dx[i] <= N && y+dy[i] >= 1 && y+dy[i] <= M) {
                        if(!visited[x+dx[i]][y+dy[i]] && arr[x+dx[i]][y+dy[i]] != -1) {
                            if(dist[x+dx[i]][y+dy[i]] >= dist[x][y] + arr[x+dx[i]][y+dy[i]]) {
                                dist[x+dx[i]][y+dy[i]] = dist[x][y] + arr[x+dx[i]][y+dy[i]];
                                priorityQueue.add(new Node(x+dx[i], y+dy[i], cost+arr[x+dx[i]][y+dy[i]]));
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
        arr = new int[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
            }
        }

        visited = new boolean[N+1][M+1];
        priorityQueue = new PriorityQueue<>();
        dist = new int[N+1][M+1];
        if(arr[1][1] != -1) {
            Dijkstra(1, 1);
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
    }
}
