import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static PriorityQueue<Node> priorityQueue;

    static class Node implements Comparable<Node> {
        String s;

        Node(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(Node o) {
            if(this.s.length() == o.s.length()) {
                return this.s.compareTo(o.s);
            }
            else {
                return this.s.length() - o.s.length();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        priorityQueue = new PriorityQueue<>();

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            priorityQueue.add(new Node(S));
        }

        String pre = "";
        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            if(!pre.equals(node.s)) {
                bw.write(node.s + "\n");
            }
            pre = node.s;
        }
        bw.flush();
        bw.close();
    }


}