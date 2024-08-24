import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static HashSet<Integer> hashSet;
    static boolean[][] visited;
    static int cnt = 0;
    static int ans = 1;
    static Queue<Node> queue;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void count(int a, int b) {
        if(visited[a][b]) return;
        queue.add(new Node(a, b));

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            int x = node.getX();
            int y = node.getY();

            if(!visited[x][y]) {
                visited[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    if (x + dx[i] >= 1 && x + dx[i] <= N && y + dy[i] >= 1 && y + dy[i] <= N) {
                        if (!visited[x + dx[i]][y + dy[i]]) {
                            queue.add(new Node(x + dx[i], y + dy[i]));
                        }
                    }
                }
            }
        }

    }

    static void down(int depth) {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(arr[i][j] <= depth) {
                    visited[i][j] = true;
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
        hashSet = new HashSet<>();

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int n =Integer.parseInt(st.nextToken());
                arr[i][j] = n;
                min = Math.min(min, n);
                max = Math.max(max, n);
                hashSet.add(n);
            }
        }

        int now = min;
        while(true) {
            if(now >= max) break;

            if(!hashSet.contains(now)) {
                now++;
                continue;
            }

            visited = new boolean[N+1][N+1];
            queue = new LinkedList<>();

            down(now);

            cnt = 0;
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(!visited[i][j]) {
                        count(i, j);
                        cnt++;
                    }
                }
            }

            ans = Math.max(ans, cnt);
            now++;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
