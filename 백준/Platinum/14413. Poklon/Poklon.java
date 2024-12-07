import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, Q;
    static int[] arr;
    static int sqrtN;
    static Query[] queries;
    static int[] cnt;
    static int m = 0;
    static int[] ans;

    static void push(int num) {
        cnt[num] += 1;
        if(cnt[num] == 2) {
            m++;
        }
        else if(cnt[num] == 3) {
            m--;
        }

    }

    static void pop(int num) {
        cnt[num] -= 1;
        if(cnt[num] == 1) {
            m--;
        }
        else if(cnt[num] == 2) {
            m++;
        }
    }

    static class Query implements Comparable<Query> {
        int left;
        int right;
        int index;
        int compare;
        Query(int left, int right, int index) {
            this.left = left;
            this.right = right;
            this.index = index;
            this.compare = left / sqrtN;
        }

        @Override
        public int compareTo(Query o) {
            if(this.compare == o.compare) {
                return this.right - o.right;
            }

            return this.compare - o.compare;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        sqrtN = (int) Math.sqrt(N);

        st = new StringTokenizer(br.readLine());
        int M = 0;
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            M = Math.max(M, arr[i]);
        }

        queries = new Query[Q];
        cnt = new int[M+1];
        ans = new int[Q];

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            queries[i] = new Query(l, r, i);
        }

        Arrays.sort(queries);

        int l = queries[0].left;
        int r = queries[0].right;

        for(int i = l; i <= r; i++) {
            push(arr[i]);
        }
        ans[queries[0].index] = m;

        for(int i = 1; i < Q; i++) {
            Query query = queries[i];

            for(int j = query.left; j < l; j++) {
                push(arr[j]);
            }
            for(int j = r+1; j <= query.right; j++) {
                push(arr[j]);
            }
            for(int j = l; j < query.left; j++) {
                pop(arr[j]);
            }
            for(int j = query.right+1; j <= r; j++) {
                pop(arr[j]);
            }

            l = query.left;
            r = query.right;
            ans[query.index] = m;
        }

        for(int i = 0; i < Q; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
