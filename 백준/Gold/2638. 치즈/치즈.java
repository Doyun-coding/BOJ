import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[][] arr;
    static Queue<Node> queue;
    static Stack<Node> stack;
    static boolean[][] visited;
    static int cnt = 0;
    static int time = 0;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void BFS(int a, int b) {
        queue.add(new Node(a, b));
        while(!queue.isEmpty()) {
            Node curNode = queue.remove();
            int x = curNode.getX();
            int y = curNode.getY();
            arr[x][y] = -1;
            if(!visited[x][y]) {
                visited[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    if (x + dx[i] >= 1 && x + dx[i] <= N && y + dy[i] >= 1 && y + dy[i] <= M && !visited[x + dx[i]][y + dy[i]]) {
                        if (arr[x + dx[i]][y + dy[i]] == 0) {
                            queue.add(new Node(x + dx[i], y + dy[i]));
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
        visited = new boolean[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queue = new LinkedList<>();

        for(int i = 1; i <= M; i++) {
            if(arr[1][i] == 0) {
                BFS(1, i);
            }

            if(arr[N][i] == 0) {
                BFS(N, i);
            }
        }

        for(int i = 2; i < N; i++) {
            if(arr[i][1] == 0) {
                BFS(i, 1);
            }

            if(arr[i][M] == 0) {
                BFS(i, M);
            }
        }

        stack = new Stack<>();
        while(true) {
            cnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if(!visited[i][j]) {
                        if (arr[i][j] == 1) {
                            int count = 0;
                            for (int k = 0; k < 4; k++) {
                                if (i + dx[k] >= 1 && i + dx[k] <= N && j + dy[k] >= 1 && j + dy[k] <= M) {
                                    if (arr[i + dx[k]][j + dy[k]] == -1) {
                                        count++;
                                    }
                                }
                            }
                            if (count >= 2) {
                                stack.add(new Node(i, j));
                                cnt++;
                            }
                        }
                    }
                }
            }

            if(cnt == 0) break;
            time++;

            while(!stack.isEmpty()) {
                Node node = stack.pop();

                BFS(node.getX(), node.getY());
            }

        }
        bw.write(time + "\n");
        bw.flush();
        bw.close();
    }
}
