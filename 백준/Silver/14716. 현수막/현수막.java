import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[][] arr;
    static int cnt = 0;
    static boolean[][] visited;
    static Queue<Node> queue;

    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

    static void BFS(int a, int b) {
        queue.add(new Node(a, b));
        while(!queue.isEmpty()) {
            Node curNode = queue.remove();
            int x = curNode.getX();
            int y = curNode.getY();
            if(!visited[x][y]) {
                visited[x][y] = true;

                for(int i = 0; i < 8; i++) {
                    if(x+dx[i] >= 1 && x+dx[i] <= N && y+dy[i] >= 1 && y+dy[i] <= M) {
                        if(!visited[x+dx[i]][y+dy[i]] && arr[x+dx[i]][y+dy[i]] == 1) {
                            queue.add(new Node(x+dx[i], y+dy[i]));
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N+1][M+1];
        queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    BFS(i, j);
                    cnt++;
                }
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
