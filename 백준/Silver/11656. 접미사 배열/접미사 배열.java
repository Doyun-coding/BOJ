import java.io.*;
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
        String getS() {
            return this.s;
        }

        @Override
        public int compareTo(Node o) {
            return this.s.compareTo(o.s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < S.length(); i++) {
            String s = "";
            for(int j = i; j < S.length(); j++) {
                s += String.valueOf(S.charAt(j));
            }
            priorityQueue.add(new Node(s));
        }

        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            bw.write(node.getS() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
