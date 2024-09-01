import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static String S;
    static PriorityQueue<Node> priorityQueue;

    static class Node implements Comparable<Node> {
        String s;
        Node(String s) {
            this.s = s;
        }
        String getString() {
            return this.s;
        }


        @Override
        public int compareTo(Node o) {
            int a = Integer.parseInt(this.s);
            int b = Integer.parseInt(o.s);
            return a - b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < S.length(); i++) {
            String s = String.valueOf(S.charAt(i));
            priorityQueue.add(new Node(s));
        }

        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            String p = node.getString();
            bw.write(p + "");
        }
        bw.flush();
        bw.close();

    }
}
