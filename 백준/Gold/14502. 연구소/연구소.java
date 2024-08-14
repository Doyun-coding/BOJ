import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[][] arr;
    static Node A, B, C;
    static int max = 0;
    static int cnt = -3;
    static ArrayList<Node> virus;
    static boolean[][] visited;
    static Queue<Node> queue;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

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

    static void bfs(int count) {
        visited = new boolean[N+1][M+1];
        queue = new LinkedList<>();
        for(int i = 0; i < virus.size(); i++) {
            if(count == 0) break;

            Node node = virus.get(i);
            queue.add(new Node(node.getX(), node.getY()));

            while(!queue.isEmpty()) {
                Node q = queue.remove();
                int x = q.getX();
                int y = q.getY();
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    count--;

                    for(int j = 0; j < 4; j++) {
                        if(x+dx[j] >= 1 && x+dx[j] <= N && y+dy[j] >= 1 && y+dy[j] <= M && !visited[x+dx[j]][y+dy[j]]) {
                            if(arr[x+dx[j]][y+dy[j]] == 0) {
                                //System.out.println("x : " + x+dx[j] + "y : " + y+dy[j]);
                                queue.add(new Node(x+dx[j], y+dy[j]));
                            }
                        }
                    }
                }
            }
        }

        max = Math.max(max, count);
    }

    static void move(int x, int y) throws IOException {
        if(y > M) {
            move(x+1, 1);
            return;
        }

        if(x > N) {
            return;
        }

        if(arr[x][y] == 1 || arr[x][y] == 2) {
            move(x, y+1);
            return;
        }

        arr[x][y] = 1;
        bfs(cnt);
        arr[x][y] = 0;
        move(x, y+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        virus = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
                if(n == 0) {
                    cnt++;
                }
                else if(n == 2) {
                    cnt++;
                    virus.add(new Node(i, j));
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    int n = i;
                    int m = j+1;
                    while(true) {
                        if(m > M) {
                            n++;
                            m = 1;
                        }

                        if(n > N) {
                            break;
                        }

                        if(arr[n][m] == 1 || arr[n][m] == 2) {
                            m++;
                            continue;
                        }

                        arr[n][m] = 1;
                        move(n, m+1);
                        arr[n][m] = 0;
                        m++;
                    }
                    arr[i][j] = 0;
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
