import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static Node[] arr;
    static int[] segmentTree;
    static PriorityQueue<Node> priorityQueue;
    static int ans = 0;

    static int update(int start, int end, int node, int idx, int dif) {
        if(idx < start || idx > end) {
            return 0;
        }

        if(start == end) {
            return segmentTree[node] = dif;
        }

        int mid = (start + end) / 2;

        return segmentTree[node] = Math.max(segmentTree[node] , Math.max(update(start, mid, node * 2, idx, dif), update(mid + 1, end, node * 2 + 1, idx, dif)));
    }

    static int maxFind(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return 0;
        }

        if(left <= start && right >= end) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;

        return Math.max(maxFind(start, mid, node * 2, left, right), maxFind(mid + 1, end, node * 2 + 1, left, right));
    }

    static class Node implements Comparable<Node> {
        int data;
        int index;

        Node(int data, int index) {
            this.data = data;
            this.index = index;
        }

        int getData() {
            return this.data;
        }
        int getIndex() {
            return this.index;
        }

        @Override
        public int compareTo(Node o) {
            if(this.data != o.data) {
                return this.data - o.data;
            }
            else {
                return o.index - this.index;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new Node[N+1];

        priorityQueue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            priorityQueue.add(new Node(Integer.parseInt(st.nextToken()), i));
        }

        segmentTree = new int[4*N];

        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            int index = node.getIndex();

            int m = maxFind(1, N, 1, 1, index-1);
            m++;
            ans = Math.max(ans, m);
            update(1, N, 1, index, m);
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
