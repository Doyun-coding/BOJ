import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static boolean[][] visit;
    static int cnt = 0;

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

    static void move(int x, int y) {
        visited[x][y] = true;

        int n = arr[x][y];
        if(n == 1 && x-1 >= 1) {
            if(visited[x-1][y]) {
                if(!visit[x-1][y]) {
                    cnt++;
                }
            }
            else {
                move(x - 1, y);
            }
        }
        else if(n == 2 && x+1 <= N) {
            if(visited[x+1][y]) {
                if(!visit[x+1][y]) {
                    cnt++;
                }
            }
            else {
                move(x + 1, y);
            }
        }
        else if(n == 3 && y-1 >= 1) {
            if(visited[x][y-1]) {
                if(!visit[x][y-1]) {
                    cnt++;
                }
            }
            else {
                move(x, y - 1);
            }
        }
        else if(n == 4 && y+1 <= M) {
            if(visited[x][y+1]) {
                if(!visit[x][y+1]) {
                    cnt++;
                }
            }
            else {
                move(x, y + 1);
            }
        }

        visit[x][y] = true;
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
        visit = new boolean[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 1; j <= M; j++) {
                if(s.charAt(j-1) == 'U') {
                    arr[i][j] = 1;
                }
                else if(s.charAt(j-1) == 'D') {
                    arr[i][j] = 2;
                }
                else if(s.charAt(j-1) == 'L') {
                    arr[i][j] = 3;
                }
                else if(s.charAt(j-1) == 'R') {
                    arr[i][j] = 4;
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(!visited[i][j]) {
                    move(i, j);
                }
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
