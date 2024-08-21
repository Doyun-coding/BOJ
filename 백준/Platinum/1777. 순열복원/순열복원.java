import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[] is;
    static int[] segmentTree;
    static int[] arr;

    static void setArrangeTree(int start, int end, int node, int n, int i) {
        if(start == end) {
            arr[start] = i;
            segmentTree[1] -= 1;
            return;
        }

        int mid = (start + end) / 2;

        if(segmentTree[node*2+1] >= n) {
            segmentTree[node*2+1] -= 1;
            setArrangeTree(mid + 1, end, node * 2 + 1, n, i);
            return;
        }
        else {
            segmentTree[node*2] -= 1;
            n -= segmentTree[node*2+1];
            setArrangeTree(start, mid, node * 2, n, i);
            return;
        }

    }

    static int initTree(int start, int end, int node) {
        if(start == end) {
            segmentTree[node] = 1;
            return segmentTree[node];
        }

        int mid = (start + end) / 2;

        return segmentTree[node] = initTree(mid + 1, end, node * 2 + 1) + initTree(start, mid, node * 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        is = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            is[i] = Integer.parseInt(st.nextToken());
        }

        segmentTree = new int[4*N];
        arr = new int[N+1];

        initTree(1, N, 1);

        for(int i = N; i >= 1; i--) {
            int n = is[i];

            setArrangeTree(1, N, 1, n+1, i);
        }

        for(int i = 1; i <= N; i++) {
            bw.write(arr[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
