import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static ArrayList<Node> arrayList;

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
        arrayList = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1) {
                    arrayList.add(new Node(i, j));
                }
            }
        }

        int sX = arrayList.get(0).getX();
        int sY = arrayList.get(0).getY();
        int eX = arrayList.get(1).getX();
        int eY = arrayList.get(1).getY();

        int sum = Math.abs(eX - sX) + Math.abs(eY-sY);

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
    }
}
