import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static PriorityQueue<Node> priorityQueue;

    static class Node implements Comparable<Node> {
        int x;

        Node(int x) {
            this.x = x;
        }

        int getX() {
            return this.x;
        }

        @Override
        public int compareTo(Node o) {
            if(Math.abs(this.x) == Math.abs(o.x)) {
                if(this.x == o.x) {
                    return 0;
                }
                else {
                    if(this.x > o.x) {
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
            }
            else {
                return Math.abs(this.x) - Math.abs(o.x);
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
            int n = Integer.parseInt(st.nextToken());

            if(n != 0) {
                priorityQueue.add(new Node(n));
            }
            else {
                if(!priorityQueue.isEmpty()) {
                    Node node = priorityQueue.remove();
                    bw.write(node.getX() + "\n");
                }
                else {
                    bw.write("0\n");
                }

            }
        }
        bw.flush();
        bw.close();
    }

}