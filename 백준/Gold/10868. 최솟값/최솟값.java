import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[] arr;
    static int[] minTree;

    static int minFind(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return Integer.MAX_VALUE;
        }

        if(left <= start && end <= right) {
            return minTree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(minFind(start, mid, node * 2, left, right), minFind(mid + 1, end, node * 2 + 1, left, right));
    }

    static int minInit(int start, int end, int node) {
        if(start == end) {
            return minTree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return minTree[node] = Math.min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        minTree = new int[4*N];

        minInit(1, N, 1);
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            bw.write(minFind(1, N, 1, left, right) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
