import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[][] arr;
    static int X, Y;
    static int size = 2;
    static int eat = 0;
    static Queue<Node> queue;
    static boolean[][] visited;
    static boolean check = false;
    static int ans = 0;
    static Stack<Node> stack;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static void BFS(int a, int b) {
        queue.add(new Node(a, b, 0));
        while(!queue.isEmpty()) {
            Node curNode = queue.remove();
            int x = curNode.getX();
            int y = curNode.getY();
            int cnt = curNode.getCnt();
            if(!visited[x][y]) {
                visited[x][y] = true;
                for(int i = 0; i < 4; i++) {
                    if(x+dx[i] >= 1 && x+dx[i] <= N && y+dy[i] >= 1 && y+dy[i] <= N) {
                        if(!visited[x+dx[i]][y+dy[i]] && arr[x+dx[i]][y+dy[i]] <= size) {
                            if(arr[x+dx[i]][y+dy[i]] == 0 || arr[x+dx[i]][y+dy[i]] == size) {
                                if(!check) {
                                    queue.add(new Node(x + dx[i], y + dy[i], cnt + 1));
                                }
                            }
                            else {
                                check = true;
                                stack.add(new Node(x+dx[i], y+dy[i], cnt+1));
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
        arr = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 9) {
                    X = i;
                    Y = j;
                    arr[i][j] = 0;
                }
                else {
                    arr[i][j] = n;
                }
            }
        }

        while(true) {
            queue = new LinkedList<>();
            stack = new Stack<>();
            visited = new boolean[N+1][N+1];
            BFS(X, Y);

            if(!check) break;

            int x = Integer.MAX_VALUE;
            int y = Integer.MAX_VALUE;
            int cnt = Integer.MAX_VALUE;
            while(!stack.isEmpty()) {
                Node node = stack.pop();
                if(node.getCnt() == cnt) {
                    if (node.getX() <= x) {
                        if (node.getX() == x) {
                            if (node.getY() < y) {
                                x = node.getX();
                                y = node.getY();
                            }
                        } else {
                            x = node.getX();
                            y = node.getY();
                        }
                    }
                }
                else if(node.getCnt() < cnt) {
                    cnt = node.getCnt();
                    x = node.getX();
                    y = node.getY();
                }
            }
            X = x;
            Y = y;
            ans += cnt;
            eat++;
            arr[X][Y] = 0;
            if(eat >= size) {
                size++;
                eat = 0;
            }
            check = false;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

}