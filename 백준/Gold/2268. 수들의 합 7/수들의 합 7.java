import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
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

        if(start >= left && end <= right) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        for(int i = 0; i <= N; i++) {
            arr[i] = 0;
        }
        segmentTree = new long[4*N];

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 0) {
                if(b < c) {
                    sb.append(sum(1, N, 1, b, (int) c) + "\n");
                }
                else {
                    sb.append(sum(1, N, 1, (int) c, b) + "\n");
                }
            }
            else if(a == 1) {
                long dif = c - arr[b];
                arr[b] = c;
                update(1, N, 1, b, dif);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
