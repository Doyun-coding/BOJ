import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[][] arr;
    static int[][] dist;
    static boolean[][] visited;
    static PriorityQueue<Node> priorityQueue;
    static int C = 0;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void Dijkstra(int x, int y) {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[x][y] = arr[x][y];

        priorityQueue.add(new Node(x, y, dist[x][y]));
        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            int curX = node.getX();
            int curY = node.getY();

            if(visited[N][N]) return;

            if(!visited[curX][curY]) {
                visited[curX][curY] = true;
                for(int i = 0; i < 4; i++) {
                    if(curX+dx[i] >= 1 && curX+dx[i] <= N && curY+dy[i] >= 1 && curY+dy[i] <= N && !visited[curX+dx[i]][curY+dy[i]]) {
                        if(dist[curX+dx[i]][curY+dy[i]] > dist[curX][curY] + arr[curX+dx[i]][curY+dy[i]]) {
                            dist[curX+dx[i]][curY+dy[i]] = dist[curX][curY] + arr[curX+dx[i]][curY+dy[i]];
                            priorityQueue.add(new Node(curX+dx[i], curY+dy[i], dist[curX+dx[i]][curY+dy[i]]));
                        }

                    }
                }

            }
        }

    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int weight;

        Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
        int getWeight() {
            return this.weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while(true) {
            C++;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if(N <= 0) break;

            arr = new int[N+1][N+1];
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dist = new int[N+1][N+1];
            visited = new boolean[N+1][N+1];
            priorityQueue = new PriorityQueue<>();

            Dijkstra(1, 1);

            bw.write("Problem " + C + ": " + dist[N][N] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
