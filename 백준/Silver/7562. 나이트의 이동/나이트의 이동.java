import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int T;
    static int N;
    static int[][] arr;
    static Queue<Node> queue;
    static Queue<Node> queue2;
    static boolean[][] visited;
    static int cnt = -1;

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static void BFS(int a, int b, int endX, int endY) {
        queue.add(new Node(a, b));
        while(true) {
            cnt++;
            while (!queue.isEmpty()) {
                Node curNode = queue.remove();
                int x = curNode.getX();
                int y = curNode.getY();
                if (!visited[x][y]) {
                    visited[x][y] = true;

                    if(x == endX && y == endY) return;

                    for (int i = 0; i < 8; i++) {
                        if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < N) {
                            if (!visited[x + dx[i]][y + dy[i]]) {
                                queue2.add(new Node(x + dx[i], y + dy[i]));
                            }
                        }
                    }
                }
            }

            cnt++;
            while (!queue2.isEmpty()) {
                Node curNode = queue2.remove();
                int x = curNode.getX();
                int y = curNode.getY();
                if (!visited[x][y]) {
                    visited[x][y] = true;

                    if(x == endX && y == endY) return;

                    for (int i = 0; i < 8; i++) {
                        if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < N) {
                            if (!visited[x + dx[i]][y + dy[i]]) {
                                queue.add(new Node(x + dx[i], y + dy[i]));
                            }
                        }
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
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
            arr = new int[N][N];

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            queue = new LinkedList<>();
            queue2 = new LinkedList<>();
            visited = new boolean[N][N];
            cnt = -1;
            BFS(startX, startY, endX, endY);

            bw.write(cnt + "\n");

        }
        bw.flush();
        bw.close();
    }
}
