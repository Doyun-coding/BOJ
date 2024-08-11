import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M, K;
    static int[] arr;
    static long[] mTree;
    static long ans = 1;

    static long update(int start, int end, int node, int idx, int pre, int dif) {
        if(start > idx || end < idx) {
            return mTree[node];
        }

        if(start == end) {
            return mTree[node] = dif;
        }

        int mid = (start + end) / 2;

        return mTree[node] = (update(start, mid, node * 2, idx, pre, dif) * update(mid + 1, end, node * 2 + 1, idx, pre, dif)) % 1000000007;
    }

    static long multi(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return 1;
        }

        if(left <= start && end <= right) {
            return mTree[node] % 1000000007;
        }

        int mid = (start + end) / 2;

        return ((multi(start, mid, node * 2, left, right) % 1000000007) * (multi(mid + 1, end, node * 2 + 1, left, right) % 1000000007)) % 1000000007;
    }

    static long initTree(int start, int end, int node) {
        if(start == end) {
            return mTree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return mTree[node] = (initTree(start, mid, node * 2) * initTree(mid + 1, end, node * 2 + 1)) % 1000000007;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mTree = new long[4*N];

        initTree(1, N, 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1) {
                int pre = arr[b];
                int dif = c;
                arr[b] = c;
                update(1, N, 1, b, pre, dif);
            }
            else if(a == 2) {
                ans = 1;
                ans *= multi(1, N, 1, b, c);
                sb.append(ans + "\n");
            }
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
