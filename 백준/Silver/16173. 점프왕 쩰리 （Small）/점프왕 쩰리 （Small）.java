import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[][] arr;
    static Queue<Node> queue;
    static boolean check = false;
    static boolean[][] visited;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static void BFS(int a, int b) {
        queue.add(new Node(a, b));
        while(!queue.isEmpty()) {
            Node curNode = queue.remove();
            int x = curNode.getX();
            int y = curNode.getY();
            int move = arr[x][y];
            if(!visited[x][y]) {
                visited[x][y] = true;
                if (move >= 3) {
                    continue;
                }

                if (x == N && y == N) {
                    check = true;
                    return;
                }

                for (int i = 0; i < 2; i++) {
                    int X = (x + (dx[i] * move));
                    int Y = (y + (dy[i] * move));
                    if (X >= 1 && X <= N && Y >= 1 && Y <= N) {
                        if (arr[X][Y] <= 2 && !visited[X][Y]) {
                            queue.add(new Node(X, Y));
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
            for(int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue = new LinkedList<>();
        visited = new boolean[N+1][N+1];
        BFS(1, 1);

        if(check) {
            bw.write("HaruHaru\n");
        }
        else {
            bw.write("Hing\n");
        }
        bw.flush();
        bw.close();
    }
}
