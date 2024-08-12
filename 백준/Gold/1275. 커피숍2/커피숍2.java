import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, Q;
    static long[] arr;
    static long[] segmentTree;

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

    static long sum(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return 0;
        }

        if(start >= left &&  end <= right) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static long initTree(int start, int end, int node) {
        if(start == end) {
            return segmentTree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return segmentTree[node] = initTree(start, mid, node * 2) + initTree(mid + 1, end, node * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        segmentTree = new long[4*N];

        initTree(1, N, 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(x < y) {
                sb.append(sum(1, N, 1, x, y) + "\n");
            }
            else {
                sb.append(sum(1, N, 1, y, x) + "\n");
            }

            long dif = b - arr[a];
            arr[a]  = b;
            update(1, N, 1, a, dif);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
