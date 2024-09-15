import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int[][] arr;
    static ArrayList<Node> arrayList;
    static Queue<Node> queue;
    static boolean[][] visited;
    static boolean check = false;

    static int[] dx = {0, 0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {0, 1, -1, 0, 0, 1, -1, -1, 1};

    static void BFS() {
        int size = queue.size();
        for(int i = 1; i <= size; i++) {
            if(!queue.isEmpty()) {
                Node curNode = queue.remove();
                int x = curNode.getX();
                int y = curNode.getY();
                if(x == 1 && y == 8) {
                    check = true;
                    return;
                }

                if(arr[x][y] != 1 && !visited[x][y]) {
                    for(int j = 0; j < 9; j++) {
                        if(x+dx[j] >= 1 && x+dx[j] <= 8 && y+dy[j] >= 1 && y+dy[j] <= 8) {
                            if(!visited[x+dx[j]][y+dy[j]] && arr[x+dx[j]][y+dy[j]] != 1) {
                                queue.add(new Node(x+dx[j], y+dy[j]));
                            }
                        }
                    }
                    visited[x][y] = true;
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
        void setX(int x) {
            this.x = x;
        }
        void setY(int y) {
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
        arr = new int[9][9];
        arrayList = new ArrayList<>();
        queue = new LinkedList<>();

        for(int i = 1; i <= 8; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            for(int j = 1; j <= 8; j++) {
                if(S.charAt(j-1) == '.') {
                    arr[i][j] = 0;
                }
                else {
                    arr[i][j] = 1;
                }
            }
        }

        queue.add(new Node(8 , 1));
        while(true) {
            if(queue.isEmpty()) break;

            visited = new boolean[9][9];
            BFS();

            if(check) break;

            for(int i = 8; i >= 1; i--) {
                for(int j = 1; j <= 8; j++) {
                    if(arr[i][j] == 1) {
                        if(i == 8) {
                            arr[i][j] = 0;
                        }
                        else {
                            arr[i][j] = 0;
                            arr[i+1][j] = 1;
                        }
                    }
                }
            }
        }

        if(check) {
            bw.write("1\n");
        }
        else {
            bw.write("0\n");
        }
        bw.flush();
        bw.close();
    }
}
