import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[][] arr;
    static PriorityQueue<Node> priorityQueue;
    static boolean[][] visited;
    static int ans = 0;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
        int getCnt() {
            return this.cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }

    static void Dijkstra(int a, int b) {
        priorityQueue.add(new Node(a, b, 0));

        while(!priorityQueue.isEmpty()) {
            Node curNode = priorityQueue.remove();
            int x = curNode.getX();
            int y = curNode.getY();
            int cnt = curNode.getCnt();

            if(x == N && y == N) {
                ans = cnt;
                return;
            }

            if(!visited[x][y]) {
                visited[x][y] = true;

                for(int i = 0; i < 2; i++) {
                    if(x+dx[i] >= 1 && x+dx[i] <= N && y+dy[i] >= 1 && y+dy[i] <= N) {
                        if(!visited[x+dx[i]][y+dy[i]]) {
                            if(arr[x][y] > arr[x+dx[i]][y+dy[i]]) {
                                priorityQueue.add(new Node(x+dx[i], y+dy[i], cnt));
                            }
                            else {
                                priorityQueue.add(new Node(x+dx[i], y+dy[i], cnt+(arr[x+dx[i]][y+dy[i]]-arr[x][y]+1)));
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
        arr = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
            }
        }

        priorityQueue = new PriorityQueue<>();
        visited = new boolean[N+1][N+1];
        Dijkstra(1, 1);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
    }
}
