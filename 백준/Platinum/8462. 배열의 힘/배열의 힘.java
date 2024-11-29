import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, T;
    static int[] arr;
    static int sqrtN;
    static Query[] queries;
    static long sum = 0;
    static int[] cnt;
    static long[] ans;

    static void push(int num) {
        sum -= (long) num * cnt[num] * cnt[num];
        cnt[num] += 1;
        sum += (long) num * cnt[num] * cnt[num];
    }

    static void pop(int num) {
        sum -= (long) num * cnt[num] * cnt[num];
        cnt[num] -= 1;
        sum += (long) num * cnt[num] * cnt[num];
    }

    static class Query implements Comparable<Query> {
        int left;
        int right;
        int compare;
        int index;

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
        T = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sqrtN = (int) Math.sqrt(N);
        queries = new Query[T];

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            queries[i] = new Query(l, r, i);
        }

        Arrays.sort(queries);

        ans = new long[T];
        cnt = new int[1000001];

        int l = queries[0].left;
        int r = queries[0].right;

        for(int i = l; i <= r; i++) {
            push(arr[i]);
        }

        ans[queries[0].index] = sum;

        for(int i = 1; i < T; i++) {
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
            ans[query.index] = sum;
        }

        for(int i = 0; i < T; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
