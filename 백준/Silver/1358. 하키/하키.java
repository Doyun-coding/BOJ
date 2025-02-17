import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int W, H, X, Y, P;
    static Node[] rectangle;
    static Node[] circle;
    static int cnt = 0;

    static class Node {
        int x;
        int y;
        int r;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Node(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
        int getR() {
            return this.r;
        }
    }

    static boolean isInRectangle(int x, int y) {
        Node node = rectangle[0];
        if(x < node.getX() || y < node.getY()) {
            return false;
        }

        node = rectangle[1];
        if(x > node.getX() || y < node.getY()) {
            return false;
        }
        node = rectangle[2];
        if(x > node.getX() || y > node.getY()) {
            return false;
        }
        node = rectangle[3];
        if(x < node.getX() || y > node.getY()) {
            return false;
        }

        return true;
    }

    static boolean isInCircle(int x, int y) {
        Node node = circle[0];
        long dist = (long) ((long) Math.pow(x-node.getX(), 2) + Math.pow(y-node.getY(), 2));
        if(dist <= Math.pow(node.getR(), 2)) {
            return true;
        }
        node = circle[1];
        dist = (long) ((long) Math.pow(x-node.getX(), 2) + Math.pow(y-node.getY(), 2));
        if(dist <= Math.pow(node.getR(), 2)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        rectangle = new Node[4];
        circle = new Node[2];
        rectangle[0] = new Node(X, Y);
        rectangle[1] = new Node(X+W, Y);
        rectangle[2] = new Node(X+W, Y+H);
        rectangle[3] = new Node(X, Y+H);
        circle[0] = new Node(X, Y+(H/2), H/2);
        circle[1] = new Node(X+W, Y+(H/2), H/2);

        for(int i = 1; i <= P; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(isInRectangle(x, y)) {
                cnt++;
            }
            else {
                if(isInCircle(x, y)) {
                    cnt++;
                }
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
