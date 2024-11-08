import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;

    static class Node {
        long x;
        long y;

        Node(long x, long y) {
            this.x = x;
            this.y = y;
        }

        long getX() {
            return this.x;
        }
        long getY() {
            return this.y;
        }
    }

    static int CCW(Node A, Node B, Node C) {
        long value = (A.getX() * B.getY()) + (B.getX() * C.getY()) + (C.getX() * A.getY());
        value -= (B.getX() * A.getY()) + (C.getX() * B.getY()) + (A.getX() * C.getY());

        if(value > 0) return 1;
        else if(value == 0) return 0;
        else return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        long x1 = Integer.parseInt(st.nextToken());
        long y1 = Integer.parseInt(st.nextToken());
        long x2 = Integer.parseInt(st.nextToken());
        long y2 = Integer.parseInt(st.nextToken());

        Node p1 = new Node(x1, y1);
        Node p2 = new Node(x2, y2);

        st = new StringTokenizer(br.readLine());

        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        Node p3 = new Node(x1, y1);
        Node p4 = new Node(x2, y2);

        int c1 = CCW(p1, p2, p3) * CCW(p1, p2, p4);
        int c2 = CCW(p3, p4, p1) * CCW(p3, p4, p2);

        if(c1 < 0 && c2 < 0) {
            bw.write("1\n");
        }
        else {
            bw.write("0\n");
        }

        bw.flush();
        bw.close();
    }
}
