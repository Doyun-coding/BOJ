import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int Bcnt = 0;
    static int Rcnt = 0;
    static Queue<Node> queue;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void RGBFS(int x, int y, int rgb) {
        queue.add(new Node(x, y));

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            int a = node.getX();
            int b = node.getY();

            if(!visited[a][b]) {
                visited[a][b] = true;

                for(int i = 0; i < 4; i++) {
                    if(a+dx[i] >= 1 && a+dx[i] <= N && b+dy[i] >= 1 && b+dy[i] <= N) {
                        if(!visited[a+dx[i]][b+dy[i]]) {
                            if(rgb != 3) {
                                if(arr[a+dx[i]][b+dy[i]] != 3) {
                                    queue.add(new Node(a+dx[i], b+dy[i]));
                                }
                            }
                            else {
                                if(arr[a+dx[i]][b+dy[i]] == rgb) {
                                    queue.add(new Node(a+dx[i], b+dy[i]));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static void BFS(int x, int y, int rgb) {
        queue.add(new Node(x, y));

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            int a = node.getX();
            int b = node.getY();

            if(!visited[a][b]) {
                visited[a][b] = true;

                for(int i = 0; i < 4; i++) {
                    if(a+dx[i] >= 1 && a+dx[i] <= N && b+dy[i] >= 1 && b+dy[i] <= N) {
                        if(!visited[a+dx[i]][b+dy[i]] && arr[a+dx[i]][b+dy[i]] == rgb) {
                            queue.add(new Node(a+dx[i], b+dy[i]));
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
        arr = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            for(int j = 1; j <= N; j++) {
                if(S.charAt(j-1) == 'R') {
                    arr[i][j] = 1;
                }
                else if(S.charAt(j-1) == 'G') {
                    arr[i][j] = 2;
                }
                else if(S.charAt(j-1) == 'B') {
                    arr[i][j] = 3;
                }
            }
        }

        visited = new boolean[N+1][N+1];
        queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(!visited[i][j]) {
                    BFS(i, j, arr[i][j]);
                    Bcnt++;
                }
            }
        }

        visited = new boolean[N+1][N+1];
        queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(!visited[i][j]) {
                    RGBFS(i, j, arr[i][j]);
                    Rcnt++;
                }
            }
        }

        bw.write(Bcnt + " " + Rcnt + "\n");
        bw.flush();
        bw.close();
    }
}
