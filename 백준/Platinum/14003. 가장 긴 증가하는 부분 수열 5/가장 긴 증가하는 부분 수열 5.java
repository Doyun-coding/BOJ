import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static PriorityQueue<Node> priorityQueue;
    static SegmentNode[] segmentTree;
    static int[] arr;
    static int[] dp;
    static int f = 0;
    static int ans = 0;
    static Stack<Integer> stack;

    static void RPL(int node) {
        if(f == 0) return;

        if(node < 4 * N) {
            RPL(node * 2 + 1);
            if(segmentTree[node].getN() != 0) {
                if(segmentTree[node].getN() == f) {
                    stack.add(segmentTree[node].getData());
                    f--;
                }
            }
            RPL(node * 2);
        }
    }

    static int update(int start, int end, int node, int idx, int dif, SegmentNode sN) {
        if(idx < start || idx > end) {
            return 0;
        }

        if(segmentTree[node].getN() < dif) {
            segmentTree[node] = sN;
        }

        if(start == end) {
            segmentTree[node] = sN;
            return dp[idx] = segmentTree[node].getN();
        }

        int mid = (start + end) / 2;

        int max = Math.max(update(start, mid, node * 2, idx, dif, sN), update(mid + 1, end, node * 2 + 1, idx, dif, sN));
        if(max < sN.getN()) {
            segmentTree[node] = sN;
            return sN.getN();
        }
        else {
            return max;
        }
    }

    static int maxFind(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return 0;
        }

        if(start >= left && end <= right) {
            return segmentTree[node].getN();
        }

        int mid = (start + end) / 2;

        return Math.max(maxFind(start , mid, node * 2, left, right), maxFind(mid + 1, end, node * 2 + 1, left, right));
    }

    static class SegmentNode {
        int n;
        int data;
        int index;
        SegmentNode(int n, int data, int index) {
            this.n = n;
            this.data = data;
            this.index = index;
        }

        int getN() {
            return this.n;
        }
        int getData() {
            return this.data;
        }
        int getIndex() {
            return this.index;
        }
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

        arr = new int[N+1];
        dp = new int[N+1];
        priorityQueue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            priorityQueue.add(new Node(arr[i], i));
            dp[i] = 1;
        }

        segmentTree = new SegmentNode[4*N];
        for(int i = 0; i < 4 * N; i++) {
            segmentTree[i] = new SegmentNode(0, 0, 0);
        }

        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            int data = node.getData();
            int index = node.getIndex();

            int m = maxFind(1, N, 1, 1, index-1);
            m++;

            ans = Math.max(ans, m);
            update(1, N, 1, index, m, new SegmentNode(m, data, index));
        }

        stack = new Stack<>();
        f = ans;
        //RPL(1);

        bw.write(ans + "\n");

        for(int i = N; i >= 1; i--) {
            if(f == 0) break;

            if(dp[i] == f) {
                stack.add(arr[i]);
                f--;
            }
        }

        while(!stack.isEmpty()) {
            int s = stack.pop();
            bw.write(s + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
    }
}
