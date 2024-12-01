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
    static int[] count;
    static int m = 0;
    static int[] ans;

    static void push(int num) {
        count[cnt[num]] -= 1;
        cnt[num] += 1;
        count[cnt[num]] += 1;

        m = Math.max(m, cnt[num]);
    }

    static void pop(int num) {
        if(m == cnt[num] && count[cnt[num]] <= 1) {
            m--;
        }

        count[cnt[num]] -= 1;
        cnt[num] -= 1;
        count[cnt[num]] += 1;
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
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            n += 100000;
            arr[i] = n;
        }

        queries = new Query[Q];

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            queries[i] = new Query(l, r, i);
        }
        Arrays.sort(queries);

        cnt = new int[200002];
        count = new int[100001];
        int l = queries[0].left;
        int r = queries[0].right;

        for(int i = l; i <= r; i++) {
            push(arr[i]);
        }

        ans = new int[Q];

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
