import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, K;
    static int[][] arr;
    static Queue<Node>[] queues;
    static int S, X, Y;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void BFS(int k) {
        int length = queues[k].size();
        for(int i = 1; i <= length; i++) {
            if(!queues[k].isEmpty()) {
                Node curNode = queues[k].remove();
                int x = curNode.getX();
                int y = curNode.getY();
                for(int j = 0; j < 4; j++) {
                    if(x+dx[j] >= 1 && x+dx[j] <= N && y+dy[j] >= 1 && y+dy[j] <= N) {
                        if(arr[x+dx[j]][y+dy[j]] == 0) {
                            arr[x+dx[j]][y+dy[j]] = k;
                            queues[k].add(new Node(x+dx[j], y+dy[j]));
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
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        queues = new Queue[K+1];
        for(int i = 0; i <= K; i++) {
            queues[i] = new LinkedList<>();
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0) {
                    int n = arr[i][j];
                    queues[n].add(new Node(i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= S; i++) {
            if(arr[X][Y] != 0) break;

            for(int k = 1; k <= K; k++) {
                BFS(k);
            }
        }

        bw.write(arr[X][Y] + "\n");
        bw.flush();
        bw.close();
    }
}
