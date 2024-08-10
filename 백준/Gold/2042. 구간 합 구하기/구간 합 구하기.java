import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M, K;
    static long[] arr;
    static long[] segmentTree;

    static long sum(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return 0;
        }

        if(left <= start && right >= end) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int start, int end, int node, int idx, long dif) {
        if(idx < start || idx > end) {
            return;
        }

        segmentTree[node] += dif;

        if(start == end) {
            return;
        }

        int mid = (start + end) / 2;

        update(start, mid, node * 2, idx, dif);
        update(mid + 1, end, node * 2 + 1, idx, dif);
    }

    static long init(int start, int end, int node) {
        if(start == end) {
            return segmentTree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return segmentTree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        segmentTree = new long[4*N];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        init(1, N, 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                long dif = c - arr[b];
                arr[b] = c;
                update(1, N, 1, b, dif);
            }
            else if(a == 2) {
                sb.append(sum(1, N, 1, b, (int) c) + "\n");
            }
        }
        bw.write(sb.toString() + "\n");

        bw.flush();
        bw.close();
    }
}
