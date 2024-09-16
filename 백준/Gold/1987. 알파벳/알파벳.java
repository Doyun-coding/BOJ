import java.io.*;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int R, C;
    static int[][] arr;
    static Stack<Node> stack;
    static boolean[][] visited;
    static boolean[] num;
    static int max = 1;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void DFS(int a, int b, int c) {

            int x = a;
            int y = b;
            int cnt = c;
            int n = arr[x][y];
            if(!num[n]) {
                num[n] = true;
                max = Math.max(max, cnt);
                if(!visited[x][y]) {
                    visited[x][y] = true;

                    for (int i = 0; i < 4; i++) {
                        if (x + dx[i] >= 1 && x + dx[i] <= R && y + dy[i] >= 1 && y + dy[i] <= C) {
                            if (!visited[x + dx[i]][y + dy[i]]) {
                                DFS(x + dx[i], y + dy[i], cnt + 1);
                            }
                        }
                    }
                }
                visited[x][y] = false;
                num[n] = false;
                if(x == 1 && y == 1) {
                    visited[x][y] = true;
                    num[n] = true;
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
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R+1][C+1];
        num = new boolean[200];

        for(int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            for(int j = 1; j <= C; j++) {
                char s = S.charAt(j-1);
                int n = s;
                arr[i][j] = n;
            }
        }

        visited = new boolean[R+1][C+1];
        DFS(1, 1, 1);

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
