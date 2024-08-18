import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int M, N, H;
    static int[][][] arr;
    static Queue<Node>[] queues;
    static Queue<NextNode> queue;
    static boolean check = false;
    static int cnt = 0;

    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};

    static void BFS(int h) {
        while(!queues[h].isEmpty()) {
            Node node = queues[h].remove();
            int x = node.getX();
            int y = node.getY();

            for(int i = 0; i < 6; i++) {
                if(x+dx[i] >= 1 && x+dx[i] <= N && y+dy[i] >= 1 && y+dy[i] <= M && h+dh[i] >= 1 && h+dh[i] <= H) {
                    if(arr[x+dx[i]][y+dy[i]][h+dh[i]] == 0) {
                        arr[x+dx[i]][y+dy[i]][h+dh[i]] = 1;
                        queue.add(new NextNode(x+dx[i], y+dy[i], h+dh[i]));
                        check = true;
                    }
                }
            }
        }

    }

    static class NextNode {
        int x;
        int y;
        int height;

        NextNode(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
        int getHeight() {
            return this.height;
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
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1][H+1];

        queues = new Queue[H+1];
        for(int i = 0; i <= H; i++) {
            queues[i] = new LinkedList<>();
        }

        for(int h = 1; h <= H; h++) {
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= M; j++) {
                    int n = Integer.parseInt(st.nextToken());
                    arr[i][j][h] = n;
                    if(n == 1) {
                        queues[h].add(new Node(i, j));
                    }
                }
            }
        }

        while(true) {
            queue = new LinkedList<>();
            for (int h = 1; h <= H; h++) {
                if (!queues[h].isEmpty()) {
                    BFS(h);
                }
            }

            if(check) {
                cnt++;
            }
            else {
                break;
            }

            while(!queue.isEmpty()) {
                NextNode nextNode = queue.remove();
                int x = nextNode.getX();
                int y = nextNode.getY();
                int height = nextNode.getHeight();

                queues[height].add(new Node(x, y));
            }

            check = false;
        }

        check = true;
        for(int h = 1; h <= H; h++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    if(arr[i][j][h] == 0) {
                        check = false;
                        break;
                    }
                }
                if(!check) break;
            }
            if(!check) break;
        }

        if(!check) {
            bw.write("-1\n");
        }
        else {
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
