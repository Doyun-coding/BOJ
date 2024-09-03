import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int R, C;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Node> queue;
    static int sheep = 0;
    static int wolf = 0;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void BFS(int a, int b) {
        int o = 0;
        int v = 0;

        queue.add(new Node(a, b));
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            int x = node.getX();
            int y = node.getY();

            if(!visited[x][y]) {
                visited[x][y] = true;

                if(arr[x][y] == 1) {
                    o++;
                }
                if(arr[x][y] == 2) {
                    v++;
                }

                for(int i = 0; i < 4; i++) {
                    if(x+dx[i] >= 1 && x+dx[i] <= R && y+dy[i] >= 1 && y+dy[i] <= C) {
                        if(!visited[x+dx[i]][y+dy[i]] && arr[x+dx[i]][y+dy[i]] != -1) {
                            queue.add(new Node(x+dx[i], y+dy[i]));
                        }
                    }

                }
            }
        }

        if(o > v) {
            sheep += o;
        }
        else {
            wolf += v;
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
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R+1][C+1];

        for(int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            for(int j = 1; j <= C; j++) {
                if(S.charAt(j-1) == '.') {
                    arr[i][j] = 0;
                }
                else if(S.charAt(j-1) == '#') {
                    arr[i][j] = -1;
                }
                else if(S.charAt(j-1) == 'o') {
                    arr[i][j] = 1;
                }
                else if(S.charAt(j-1) == 'v') {
                    arr[i][j] = 2;
                }
            }
        }

        visited = new boolean[R+1][C+1];

        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                if(!visited[i][j] && arr[i][j] != -1) {
                    queue = new LinkedList<>();
                    BFS(i, j);
                }
            }
        }

        bw.write(sheep + " " + wolf + "\n");
        bw.flush();
        bw.close();
    }
}
