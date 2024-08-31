import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[][] arr;
    static Queue<Node> queue;
    static boolean[][] visited;
    static int max = 0;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void BFS(int a, int b) {
        queue.add(new Node(a, b, 0));
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            int x = node.getX();
            int y = node.getY();
            int cnt = node.getCnt();

            max = Math.max(max, cnt);

            if(!visited[x][y]) {
                visited[x][y] = true;

                for(int i = 0; i < 4; i++) {
                    if(x+dx[i] >= 1 && x+dx[i] <= N && y+dy[i] >= 1 && y+dy[i] <= M) {
                        if(!visited[x+dx[i]][y+dy[i]] && arr[x+dx[i]][y+dy[i]] == 1) {
                            queue.add(new Node(x+dx[i], y+dy[i], cnt+1));
                        }
                    }
                }

            }
        }

    }

    static class Node {
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
            String S = st.nextToken();
            for(int j = 1; j <= M; j++) {
                if(S.charAt(j-1) == 'W') {
                    arr[i][j] = -1;
                }
                else {
                    arr[i][j] = 1;
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(arr[i][j] == 1) {
                    queue = new LinkedList<>();
                    visited = new boolean[N+1][M+1];
                    BFS(i, j);
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
