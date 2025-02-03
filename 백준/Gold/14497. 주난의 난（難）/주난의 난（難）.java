import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int x1, y1, x2, y2;
    static int[][] arr;
    static int X, Y;
    static boolean[][] visited;
    static PriorityQueue<Node> priorityQueue;
    static int ans = 0;

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

    static void BFS(int a, int b) {
        priorityQueue.add(new Node(a, b, 1));

        while(true) {
            Node curNode = priorityQueue.remove();
            int x = curNode.getX();
            int y = curNode.getY();
            int cost = curNode.getCost();
            if(arr[x][y] == 2) {
                ans = cost;
                return;
            }

            if(!visited[x][y]) {
                visited[x][y] = true;

                for(int i = 0; i < 4; i++) {
                    if(x+dx[i] >= 1 && x+dx[i] <= N && y+dy[i] >= 1 && y+dy[i] <= M) {
                        if(arr[x+dx[i]][y+dy[i]] == 1) {
                            priorityQueue.add(new Node(x+dx[i], y+dy[i], cost+1));
                        }
                        else {
                            priorityQueue.add(new Node(x+dx[i], y+dy[i], cost));
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
        visited = new boolean[N+1][M+1];

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            for(int j = 1; j <= M; j++) {
                if(S.charAt(j-1) == '1') {
                    arr[i][j] = 1;
                }
                else if(S.charAt(j-1) == '0') {
                    arr[i][j] = 0;
                }
                else if(S.charAt(j-1) == '#') {
                    arr[i][j] = 2;
                }
                else if(S.charAt(j-1) == '*') {
                    arr[i][j] = 3;
                    X = i;
                    Y = j;
                }
            }
        }

        priorityQueue = new PriorityQueue<>();
        BFS(X, Y);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
