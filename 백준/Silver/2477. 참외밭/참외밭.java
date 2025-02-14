import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int K;
    static int N, M;
    static int n, m;
    static int sum = 0;
    static ArrayList<Node> arrayList;
    static int minus = -1;

    static class Node {
        int a;
        int b;
        Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
        int getA() {
            return this.a;
        }
        int getB() {
            return this.b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();


        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList.add(new Node(a, b));

            if(a == 1 || a == 2) {
                M += b;
            }
            else {
                N += b;
            }
        }
        sum = M*N/4;

        Node pre = arrayList.get(0);
        for(int i = 1; i < arrayList.size(); i++) {
            Node node = arrayList.get(i);
            if(node.a == 1 && pre.a == 4) {
                minus = node.b * pre.b;
                break;
            }
            if(node.a == 2 && pre.a == 3) {
                minus = node.b * pre.b;
                break;
            }
            if(node.a == 3 && pre.a == 1) {
                minus = node.b * pre.b;
                break;
            }
            if(node.a == 4 && pre.a == 2) {
                minus = node.b * pre.b;
                break;
            }
            pre = node;
        }

        if(minus == -1) {
            minus = arrayList.get(0).b * arrayList.get(5).b;
        }

        sum -= minus;
        sum *= K;

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
    }
}
